package org.tis.tools.abf.module.om.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * omGroup工作组定义表，用于定义临时组、虚拟组，跨部门的项目组等。
 * 工作组实质上与机构类似，是为了将项目组、工作组等临时性的组织机构管理起来，业务上通常工作组有一定的时效性，是一个非常设机构。
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("om_group")
public class OmGroup implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * groupCode对应表字段
     */
    public static final String COLUMN_GROUP_CODE = "group_code";

    /**
     * groupName对应表字段
     */
    public static final String COLUMN_GROUP_NAME = "group_name";

    /**
     * groupType对应表字段
     */
    public static final String COLUMN_GROUP_TYPE = "group_type";

    /**
     * groupStatus对应表字段
     */
    public static final String COLUMN_GROUP_STATUS = "group_status";

    /**
     * groupDesc对应表字段
     */
    public static final String COLUMN_GROUP_DESC = "group_desc";

    /**
     * guidEmpManager对应表字段
     */
    public static final String COLUMN_GUID_EMP_MANAGER = "guid_emp_manager";

    /**
     * guidOrg对应表字段
     */
    public static final String COLUMN_GUID_ORG = "guid_org";

    /**
     * guidParents对应表字段
     */
    public static final String COLUMN_GUID_PARENTS = "guid_parents";

    /**
     * isleaf对应表字段
     */
    public static final String COLUMN_ISLEAF = "isleaf";

    /**
     * subCount对应表字段
     */
    public static final String COLUMN_SUB_COUNT = "sub_count";

    /**
     * groupLevel对应表字段
     */
    public static final String COLUMN_GROUP_LEVEL = "group_level";

    /**
     * groupSeq对应表字段
     */
    public static final String COLUMN_GROUP_SEQ = "group_seq";

    /**
     * startDate对应表字段
     */
    public static final String COLUMN_START_DATE = "start_date";

    /**
     * endDate对应表字段
     */
    public static final String COLUMN_END_DATE = "end_date";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 工作组代码:业务上对工作组的编码
     */
    public String groupCode;

    /**
     * 工作组名称
     */
    public String groupName;

    /**
     * 工作组类型:见业务字典： DICT_OM_GROUPTYPE
     */
    public String groupType;

    /**
     * 工作组状态:见业务字典： DICT_OM_GROUPSTATUS
     */
    public String groupStatus;

    /**
     * 工作组描述
     */
    public String groupDesc;

    /**
     * 负责人:选择范围来自 OM_EMPLOYEE表
     */
    public String guidEmpManager;

    /**
     * 隶属机构GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidOrg;

    /**
     * 父工作组GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidParents;

    /**
     * 是否叶子节点:见业务菜单： DICT_YON
     */
    public String isleaf;

    /**
     * 子节点数
     */
    public BigDecimal subCount;

    /**
     * 工作组层次
     */
    public BigDecimal groupLevel;

    /**
     * 工作组序列:本工作组的面包屑定位信息
     */
    public String groupSeq;

    /**
     * 工作组有效开始日期
     */
    public Date startDate;

    /**
     * 工作组有效截止日期
     */
    public Date endDate;

}

