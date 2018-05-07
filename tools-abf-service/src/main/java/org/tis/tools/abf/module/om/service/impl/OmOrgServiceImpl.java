/**
 * 
 */
package org.tis.tools.abf.module.om.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tis.tools.abf.module.common.entity.enums.YON;
import org.tis.tools.abf.module.om.dao.OmOrgMapper;
import org.tis.tools.abf.module.om.entity.OmOrg;
import org.tis.tools.abf.module.om.entity.enums.OmOrgStatus;
import org.tis.tools.abf.module.om.exception.OMExceptionCodes;
import org.tis.tools.abf.module.om.exception.OrgManagementException;
import org.tis.tools.abf.module.om.service.IOmOrgService;
import org.tis.tools.abf.module.om.service.IOrgCodeGenerator;

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
		return null;
	}

	@Override
	public boolean moveOrg(String orgCode, String fromParentsOrgCode, String toParentsOrgCode, int toSortNo) throws OrgManagementException {
		return false;
	}

	@Override
	public OmOrg copyOrg(String copyFromOrgCode) throws OrgManagementException {
		return null;
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
		return null;
	}

	@Override
	public OmOrg cancelOrg(String orgCode) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg deleteEmptyOrg(String orgCode) throws OrgManagementException {
		return null;
	}

	@Override
	public OmOrg queryOrg(String orgCode) {
		return null;
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
}
