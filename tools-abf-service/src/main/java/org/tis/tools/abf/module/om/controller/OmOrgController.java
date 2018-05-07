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

/**
 * describe: 机构controller
 *
 * @author zhaoch
 * @date 2018/3/27
**/
@RestController
@RequestMapping("/omOrg")
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
            operateType = OperateType.ADD,  // 操作类型
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



}
