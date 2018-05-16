/**
 * 
 */
package org.tis.tools.abf.module.om.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tis.tools.abf.module.ac.entity.AcMenu;
import org.tis.tools.abf.module.common.entity.enums.YON;
import org.tis.tools.abf.module.om.dao.OmOrgMapper;
import org.tis.tools.abf.module.om.entity.OmOrg;
import org.tis.tools.abf.module.om.entity.enums.OmOrgStatus;
import org.tis.tools.abf.module.om.exception.OMExceptionCodes;
import org.tis.tools.abf.module.om.exception.OrgManagementException;
import org.tis.tools.abf.module.om.service.IOmOrgService;
import org.tis.tools.abf.module.om.service.IOrgCodeGenerator;
import org.tis.tools.core.exception.ToolsRuntimeException;
import org.tis.tools.core.exception.i18.ExceptionCodes;
import org.tis.tools.core.utils.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.tis.tools.core.utils.BasicUtil.wrap;


/**
 * <pre>
 * 机构（Organization）管理服务功能的实现类
 * 
 * <pre>
 * 
 * @author megapro
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrgServiceImpl extends ServiceImpl<OmOrgMapper, OmOrg> implements IOmOrgService {

	/** 拷贝新增时，代码前缀  */
	private static final String CODE_HEAD_COPYFROM = "Copyfrom-";

	@Autowired
	private IOrgCodeGenerator orgCodeGenerator;


	@Autowired
	IOmOrgService OmOrgService;
	/**
	 * 生成机构代码
	 *
	 * @param areaCode  区域代码
	 * @param orgDegree 机构等级
	 * @return 机构代码
	 * @throws OrgManagementException
	 */
	@Override
	public String genOrgCode(String areaCode, String orgDegree) throws OrgManagementException {
		return orgCodeGenerator.genOrgCode(orgDegree, areaCode);
	}

	/**
	 *
	 * @param areaCode
	 * 			  区域代码
	 * @param orgDegree
	 *            机构等级
	 * @param orgName
	 *            机构名称
	 * @param orgType
	 *            机构类型
	 * @return
	 * @throws OrgManagementException
	 */
	@Override
	public OmOrg createRootOrg(String areaCode, String orgDegree, String orgName,  String orgType)
			throws OrgManagementException {

		OmOrg org = new OmOrg();
		// 补充信息
//		org.setGuid(GUID.org());// 补充GUID
		// 补充机构状态，新增机构初始状态为 停用
		org.setOrgStatus(OmOrgStatus.STOP);
		// 补充父机构，根节点没有父机构
		org.setGuidParents("");
		// 新增节点都先算叶子节点 Y
		org.setIsleaf(YON.YES);
		// 设置机构序列,根机构直接用guid
		org.setOrgSeq(org.getGuid());
		//设置排序字段
		EntityWrapper<OmOrg> wrapper = new EntityWrapper<>();
		wrapper.isNull(OmOrg.COLUMN_GUID_PARENTS);
		org.setSortNo(new BigDecimal(selectCount(wrapper)));
		// 收集入参
		org.setOrgCode(genOrgCode(orgDegree, areaCode));
		org.setOrgName(orgName);
		org.setOrgType(orgType);
		org.setOrgDegree(orgDegree);
		org.setArea(areaCode);
		insert(org);
		return org;
	}

	@Override
	public OmOrg createChildOrg(String areaCode, String orgDegree, String orgName, String orgType, String guidParents)
			throws OrgManagementException {
		// 查询父机构信息
		OmOrg parentsOrg = selectById(guidParents);
		if(parentsOrg == null) {
			throw new OrgManagementException(
					OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(guidParents));
		}
		String parentsOrgSeq = parentsOrg.getOrgSeq();
		OmOrg org = new OmOrg();
		// 补充信息
		// 补充机构状态，新增机构初始状态为 停用
		org.setOrgStatus(OmOrgStatus.STOP);
		// 补充父机构，根节点没有父机构
		org.setGuidParents(parentsOrg.getGuid());
		// 新增节点都先算叶子节点 Y
		org.setIsleaf(YON.YES);
		String newOrgSeq = parentsOrgSeq + "." + org.getGuid();
		// 设置机构序列,根据父机构的序列+"."+机构的GUID
		org.setOrgSeq(newOrgSeq);
		// 收集入参
		org.setOrgCode(orgCodeGenerator.genOrgCode(orgDegree, areaCode));
		org.setOrgName(orgName);
		org.setOrgType(orgType);
		org.setOrgDegree(orgDegree);
		org.setArea(areaCode);
		// 更新父节点机构 是否叶子节点 节点数 最新更新时间 和最新更新人员
		parentsOrg.setIsleaf(YON.NO);
		insert(org);//新增子节点
		updateById(parentsOrg);//更新父节点
		return org;
	}

	@Override
	public OmOrg createChildOrg(OmOrg newOrg) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg updateOrg(OmOrg omOrg) throws OrgManagementException {
		OmOrg newOmOrg  = new OmOrg();
		EntityWrapper<OmOrg> wrapper = new EntityWrapper<>();
		wrapper.eq(OmOrg.COLUMN_GUID, guid);
		if (selectOne(wrapper) == null) {
			throw new SysManagementException(
					ExceptionCodes.NOT_FOUND_WHEN_QUERY,
					wrap(OmOrg.COLUMN_GUID, guid), guid);
		} else {
			newOmOrg.setArea(omOrg.getArea());
			newOmOrg.setEndDate(omOrg.getEndDate());
			newOmOrg.setGuidParents(omOrg.getGuidParents());
			newOmOrg.setIsleaf(omOrg.getIsleaf());
			newOmOrg.setLinkMan(omOrg.getLinkMan());
			newOmOrg.setLinkTel(omOrg.getLinkTel());
			newOmOrg.setOrgAddr(omOrg.getOrgAddr());
			newOmOrg.setOrgStatus(omOrg.getOrgStatus());
			newOmOrg.setOrgType(omOrg.getOrgType());
			newOmOrg.setRemark(omOrg.getRemark());
			newOmOrg.setSortNo(omOrg.getSortNo());
			newOmOrg.setStartDate(omOrg.getStartDate());
			update(newOmOrg, wrapper);
		}
		return newOmOrg;
	}

	@Override
	public boolean moveOrg(String orgCode, String fromParentsOrgCode, String toParentsOrgCode, int toSortNo) throws OrgManagementException {
		//校验传入参数
		if (StringUtil.isEmpty(orgCode, fromParentsOrgCode,toParentsOrgCode)) {
			throw new OrgManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmOrg.COLUMN_ORG_CODE, orgCode);
		List<OmOrg> queryList = omOrgService.query(wc);
		if(queryList.size() != 1) {
			throw new OrgManagementException(
					OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(orgCode), "机构代码{0}对应的机构不存在");
		}
		OmOrg mvOrg = queryList.get(0);
		OmOrg fromParentsOrg = new OmOrg();
		OmOrg toParentsOrg = new OmOrg();
		wc.clear();
		if(!fromParentsOrgCode.equals("99999")){
			wc.andEquals(OmOrg.COLUMN_ORG_CODE, fromParentsOrgCode);
			queryList = omOrgService.query(wc);
			if(queryList.size() != 1) {
				throw new OrgManagementException(
						OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(orgCode), "机构代码{0}对应的机构不存在");
			}
			fromParentsOrg = queryList.get(0);
		}
		if (!toParentsOrgCode.equals("99999")) {
			wc.andEquals(OmOrg.COLUMN_ORG_CODE, toParentsOrgCode);
			queryList = omOrgService.query(wc);
			if(queryList.size() != 1) {
				throw new OrgManagementException(
						OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(orgCode), "机构代码{0}对应的机构不存在");
			}
			toParentsOrg = queryList.get(0);
		}
		//调整移动的机构
		//获取原排序字段
		BigDecimal sortNo = mvOrg.getSortNo();
		if(toParentsOrg.getGuid() == null){
			mvOrg.setGuidParents("");
			mvOrg.setOrgSeq(mvOrg.getGuid());
			mvOrg.setSortNo(new BigDecimal(toSortNo));
		}else{
			mvOrg.setGuidParents(toParentsOrg.getGuid());
			mvOrg.setOrgSeq(toParentsOrg.getOrgSeq() + "." + mvOrg.getGuid());
			mvOrg.setSortNo(new BigDecimal(toSortNo));
		}


		//调整移动机构的序列
		wc.clear();
		wc.andFullLike(OmOrg.COLUMN_ORG_SEQ, mvOrg.getGuid());
		queryList =
				omOrgService.query(wc);
		queryList.remove(mvOrg);
		for (OmOrg org : queryList) {
			org.setOrgSeq(org.getOrgSeq().replace(fromParentsOrg.getOrgSeq(),mvOrg.getOrgSeq()));
		}
		final OmOrg fParentsOrg = fromParentsOrg;
		final OmOrg tParentsOrg = toParentsOrg;
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					omOrgService.update(mvOrg);
					//调整原父机构
					if (fParentsOrg.getGuid() == null) {
						omOrgServiceExt.reorderOrg(OMConstants.ROOT_FLAG,sortNo,OMConstants.RECORD_AUTO_MINUS);
					}else{
						omOrgServiceExt.reorderOrg(fParentsOrg.getGuid(),sortNo,OMConstants.RECORD_AUTO_MINUS);
					}
					//调整新父机构
					if(tParentsOrg.getGuid() == null){
						omOrgServiceExt.reorderOrg(OMConstants.ROOT_FLAG, mvOrg.getSortNo(), OMConstants.RECORD_AUTO_PLUS);
					}else{
						omOrgServiceExt.reorderOrg(tParentsOrg.getGuid(), mvOrg.getSortNo(), OMConstants.RECORD_AUTO_PLUS);
					}
					omOrgService.update(fParentsOrg);
					omOrgService.update(tParentsOrg);
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new OrgManagementException(
							OMExceptionCodes.FAILURE_WHRN_CREAT_BUSIORG, wrap("AC_MENU", e.getCause().getMessage()));
				}
			}
		});
		return true;
	}

	@Override
	public OmOrg copyOrg(String copyFromOrgCode) throws OrgManagementException {
		if (!StringUtil.noEmpty(copyFromOrgCode)) {
			throw new OrgManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}

		if (!omOrgServiceExt.isExit(copyFromOrgCode)) {
			throw new OrgManagementException(OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE,
					wrap(copyFromOrgCode), "拷贝机构时，找不到参照机构{0}！");
		}

		//获取参照机构
		OmOrg newOrg = omOrgServiceExt.loadByOrgCode(copyFromOrgCode) ;

		//修改为新增机构
		//注：其他未修改的值同参考机构
		newOrg.setGuid(GUID.org());
		newOrg.setOrgCode(boshGenOrgCode.genOrgCode(newOrg.getOrgDegree(), newOrg.getArea())) ;
		newOrg.setOrgName(CODE_HEAD_COPYFROM+newOrg.getOrgName()) ;
		newOrg.setOrgStatus(OMConstants.ORG_STATUS_STOP);//新机构状态 停用
		newOrg.setOrgSeq(chgOrgSeq(newOrg.getOrgSeq(),newOrg.getGuid()));//设置新的机构序列
		newOrg.setStartDate(null);//置空生效日期
		newOrg.setEndDate(null);//置空失效日期
		newOrg.setCreateTime(new Date());//创建时间
		newOrg.setLastUpdate(new Date());//更新时间
		newOrg.setSortNo(new BigDecimal(0));//TODO 应该放在当前父机构下最后
		newOrg.setUpdator("");//TODO FIXME 服务提供者如何获取 请求上下文，以获得柜员身份
		newOrg.setIsleaf(CommonConstants.YES);//新增节点都先算叶子节点 Y
		newOrg.setSubCount(new BigDecimal(0)); //浅拷贝，下级子节点数为0

		try {
			omOrgService.insert(newOrg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_COPY_ORG,
					wrap(copyFromOrgCode, e));
		}

		return newOrg;
	}

	@Override
	public OmOrg copyOrgDeep(String copyFromOrgCode, boolean copyOrgRole, boolean copyPosition, boolean copyPositionRole, boolean copyGroup, boolean copyGroupRole) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg enabledOrg(String orgCode, Date startDate, Date endDate) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg reenabledOrg(String orgCode) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg disabledOrg(String orgCode) throws OrgManagementException {
		// 校验传入参数
		if(StringUtil.isEmpty(orgCode)) {
			throw new OrgManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "机构代码为空");
		}
		// 查询机构信息
		WhereCondition wc = new WhereCondition();
		wc.andEquals("ORG_CODE", orgCode);
		List<OmOrg> orgList = omOrgService.query(wc);
		// 查询是否存在
		if(orgList.size() != 1) {
			throw new OrgManagementException(
					OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(orgCode), "机构代码{0}对应的机构不存在");
		}
		OmOrg org = orgList.get(0);
		WhereCondition wc_ext = new WhereCondition(); // 用于查询下属机构
		//暂时直接停用
		org.setOrgStatus(OMConstants.ORG_STATUS_STOP);
		omOrgService.update(org);
		return org;
	}

	@Override
	public OmOrg cancelOrg(String orgCode) throws OrgManagementException {
		// 校验传入参数
		if(StringUtil.isEmpty(orgCode)) {
			throw new OrgManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY, wrap(orgCode));
		}
		// 查询机构信息
		WhereCondition wc = new WhereCondition();
		wc.andEquals("ORG_CODE", orgCode);
		List<OmOrg> orgList = omOrgService.query(wc);
		// 查询是否存在
		if(orgList.size() != 1) {
			throw new OrgManagementException(
					OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE, wrap(orgCode), "机构代码{0}对应的机构不存在");
		}
		OmOrg org = orgList.get(0);
		//查询子机构状态
		List<OmOrg> childorgList = queryAllChilds(orgCode);
		for(OmOrg og:childorgList){
			if(og.getOrgStatus().equals(OMConstants.ORG_STATUS_RUNNING)){
				throw new OrgManagementException(OMExceptionCodes.ORG_CHILDS_IS_RUNNING,wrap());
			}
		}
		//进行注销操作
		org.setOrgStatus(OMConstants.ORG_STATUS_CANCEL);
		omOrgService.update(org);
		return org;
	}

	@Override
	public OmOrg deleteEmptyOrg(String orgCode) throws OrgManagementException {
		OmOrg delOrg = omOrgServiceExt.loadByOrgCode(orgCode) ;

		if (!StringUtils.equals(OMConstants.ORG_STATUS_STOP, delOrg.getOrgStatus())) {
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHEN_DEL_MUST_STOP,
					wrap(orgCode, delOrg.getOrgStatus()));
		}


		final String guid = delOrg.getGuid();
		try {
			transactionTemplate.execute(new TransactionCallback<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					//删除机构
					omOrgService.delete(guid);
					//删除机构对应权限集映射
					acRoleServiceExt.deletePartyRole(ACConstants.PARTY_TYPE_ORGANIZATION, guid);
					return "";
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_DEEP_COPY_ORG,
					wrap(delOrg.getOrgCode(), e.getCause().getMessage()));
		}finally {
			return  delOrg;
		}
	}

	@Override
	public OmOrg queryOrg(String orgCode) {
		// 校验传入参数
		if(StringUtil.isEmpty(orgCode)) {
			throw new OrgManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "机构代码为空");
		}
		OmOrg org = selectById(orgCode) ;
		return org;
	}

	@Override
	public List<OmOrg> queryOrgsByName(String name) {
		return null;
	}

	@Override
	public List<OmOrg> queryChilds(String orgCode) {
		return null;
	}

	@Override
	public List<OmOrg> queryAllChilds(String orgCode) {
		return null;
	}

	@Override
	public List<OmOrg> queryChildsByCondition(String orgCode, OmOrg orgCondition) {
		return null;
	}

	@Override
	public List<OmOrg> queryAllRoot() {
		return null;
	}

	@Override
	public List<OmOrg> queryAllOrg() {
		return null;
	}

	@Override
	public List<OmOrg> queryGuidParents() throws OrgManagementException {
		try {
			//查询应用下父节点字段为空的菜单，即为根菜单
			EntityWrapper wrapper = new EntityWrapper();
			wrapper.or(OmOrg.COLUMN_GUID_PARENTS,"")
					.isNull(OmOrg.COLUMN_GUID_PARENTS);
			return selectList(wrapper);
		} catch (ToolsRuntimeException ae) {
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(
					"404",
					wrap(e));
		}
	}

	/**
	 * 根据父菜单查询出子菜单
	 *
	 * @param gidParents 父菜单Gid
	 */
	@Override
	public List<OmOrg> selectSubMenu(String guidParents) throws OrgManagementException {
		try {
			if (StringUtil.isEmpty(guidParents)) {
				throw new OrgManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, wrap("GUID", "OM_ORG"));
			}
			EntityWrapper wrapper = new EntityWrapper();
			wrapper.eq(OmOrg.COLUMN_GUID_PARENTS, guidParentsidParents);
			List<OmOrg> lists = selectList(wrapper);
			return lists;
		} catch (ToolsRuntimeException ae) {
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(ExceptionCodes.FAILURE_WHEN_QUERY, wrap(e));
		}
	}

}
