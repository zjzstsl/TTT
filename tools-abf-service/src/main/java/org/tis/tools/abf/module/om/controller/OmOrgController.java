package org.tis.tools.abf.module.om.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.tis.tools.abf.module.common.log.OperateLog;
import org.tis.tools.abf.module.common.log.OperateType;
import org.tis.tools.abf.module.common.log.ReturnType;
import org.tis.tools.abf.module.om.controller.request.OmOrgAddRequest;
import org.tis.tools.abf.module.om.entity.OmOrg;
import org.tis.tools.abf.module.om.service.IOmOrgService;
import org.tis.tools.core.web.controller.BaseController;
import org.tis.tools.core.web.vo.ResultVO;

import java.util.List;

/**
 * describe: 机构controller
 *
 * @author zhaoch
 * @date 2018/3/27
**/
@RestController
@RequestMapping("/omOrgs")
@Validated
public class OmOrgController extends BaseController {

    @Autowired
    private IOmOrgService orgService;

    /**
     * 新增机构综合
     *
     * @param request
     * @return
     */
    @OperateLog(
            operateType = OperateType.ADD,  // 操作类型字段
            operateDesc = "新增机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "orgCode", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PostMapping("/add")
    public ResultVO add(@RequestBody @Validated OmOrgAddRequest request) {
        OmOrg omOrg;
        if (StringUtils.isNotBlank(request.getGuidParents())) {
            omOrg = orgService.createChildOrg(request.getAreaCode(), request.getOrgDegree(),
                    request.getOrgName(), request.getOrgType(), request.getGuidParents());
        } else {
            omOrg = orgService.createRootOrg(request.getAreaCode(), request.getOrgDegree(),
                    request.getOrgName(), request.getOrgType());
        }
        return ResultVO.success("新增成功！", omOrg);
    }

    /**
     * 新建一个子节点机构
     *
     * @param OmOrg
     * @return
     */
    @OperateLog(
            operateType = OperateType.ADD,  // 操作类型字段
            operateDesc = "新增一个子节点", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "orgCode", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PostMapping("/add")
    public ResultVO createChildOrg(@RequestBody @Validated  OmOrg OmOrg) {
        OmOrg omOrg;
        omOrg = orgService.createChildOrg(OmOrg);
        return ResultVO.success("新增成功！", omOrg);
    }

    /**
     * 修改机构综合
     *
     * @param OmOrg
     * @return
     */
    @OperateLog(
            operateType = OperateType.UPDATE,  // 操作类型字段
            operateDesc = "修改机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "guid", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PutMapping
    public ResultVO updateOrg(@RequestBody @Validated OmOrg OmOrg) {
        org.tis.tools.abf.module.om.entity.OmOrg omOrg = orgService.updateOrg(OmOrg);
        return ResultVO.success("新增成功！", omOrg);
    }

    /**
     * 移动机构
     *
     * @param request
     * @return
     */
    @OperateLog(
            operateType = OperateType.UPDATE,  // 操作类型字段
            operateDesc = "移动机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "guid", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PutMapping
    public ResultVO moveOrg(@RequestBody @Validated OmOrgAddRequest request) {
        boolean bolen;
        bolen = orgService.moveOrg(request.getOrgCode(),request.getFromParentsOrgCode(),request.getToParentsOrgCode(),
                                        request.getToSortNo());
        return ResultVO.success("移动成功！", bolen);
    }

    /**
     * 拷贝机构
     *
     * @param copyFromOrgCode
     * @return
     */
    @OperateLog(
            operateType = OperateType.ADD,  // 操作类型字段
            operateDesc = "拷贝机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "orgCode", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PostMapping("/add")
    public ResultVO copyOrg(@RequestBody @Validated String copyFromOrgCode) {
        OmOrg omOrg ;
        omOrg = orgService.copyOrg(copyFromOrgCode);
        return ResultVO.success("拷贝成功！", omOrg);
    }

    /**
     * 移动机构
     *
     * @param orgCode
     * @return
     */
    @OperateLog(
            operateType = OperateType.UPDATE,  // 操作类型字段
            operateDesc = "停用机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "guid", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PutMapping
    public ResultVO disabledOrg(@RequestBody @Validated String orgCode) {
        OmOrg omOrg ;
        omOrg = orgService.disabledOrg(orgCode);
        return ResultVO.success("停用成功！", omOrg);
    }

    /**
     * 注销机构
     *
     * @param orgCode
     * @return
     */
    @OperateLog(
            operateType = OperateType.UPDATE,  // 操作类型字段
            operateDesc = "注销机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "guid", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @PutMapping
    public ResultVO cancelOrg(@RequestBody @Validated String orgCode) {
        OmOrg omOrg ;
        omOrg = orgService.cancelOrg(orgCode);
        return ResultVO.success("注销成功！", omOrg);
    }

    /**
     * 删除机构
     *
     * @param orgCode
     * @return
     */
    @OperateLog(
            operateType = OperateType.DELETE,  // 操作类型字段
            operateDesc = "删除机构", // 操作描述
            retType = ReturnType.Object, // 返回类型，对象或数组
            id = "guid", // 操作对象标识
            name = "orgName", // 操作对象名
            keys = {"orgCode", "orgName"}) // 操作对象的关键值的键值名
    @DeleteMapping("/{id}")
    public ResultVO deleteEmptyOrg(@RequestBody @Validated String orgCode) {
        OmOrg omOrg ;
        omOrg = orgService.deleteEmptyOrg(orgCode);
        return ResultVO.success("注销成功！", omOrg);
    }

    /**
     * 根据机构代码（orgCode）查询机构记录
     *
     * @param orgCode
     * @return
     */
    @GetMapping("/{id}")
    public ResultVO queryOrg(@RequestBody @Validated String orgCode) {
        OmOrg omOrg ;
        omOrg = orgService.queryOrg(orgCode);
        return ResultVO.success("查询成功！", omOrg);
    }


    /**
     * 查询所有父节点机构
     *
     * @return
     */
    @GetMapping("/queryGuidParents")
    public ResultVO queryAllOrg() {
        List omOrg ;
        omOrg = orgService.queryAllOrg();
        return ResultVO.success("查询成功！", omOrg);
    }

    /**
     * 查询所有父节点下机构
     *
     * @param guidParents
     * @return
     */
    @GetMapping("/queryGuidParents")
    public ResultVO selectSubMenu(@RequestBody @Validated String guidParents) {
        List omOrg ;
        omOrg = orgService.selectSubMenu(guidParents);
        return ResultVO.success("查询成功！", omOrg);
    }

}
