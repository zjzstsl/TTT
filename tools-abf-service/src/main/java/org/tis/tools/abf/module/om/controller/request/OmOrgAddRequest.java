package org.tis.tools.abf.module.om.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.tis.tools.core.entity.request.RestRequest;

@Data
@EqualsAndHashCode(callSuper = false)
public class OmOrgAddRequest extends RestRequest {

    @NotBlank(message = "区域代码不能为空")
    private String areaCode;

    @NotBlank(message = "机构等级不能为空")
    private String orgDegree;

    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @NotBlank(message = "机构类型不能为空")
    private String orgType;

    private String guidParents;

    private String  orgCode;

    private String fromParentsOrgCode;

    private String toParentsOrgCode;

    private int toSortNo;
}
