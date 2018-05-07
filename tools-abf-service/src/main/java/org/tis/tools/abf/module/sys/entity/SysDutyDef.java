package org.tis.tools.abf.module.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * sysDutyDef职务及responsiblity。定义职务及上下级关系（可以把“职务”理解为岗位的岗位类型，岗位是在机构、部门中实例化后的职务，如：A机构设有‘总经理’这个岗位，其职务为‘总经理’）
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_duty_def")
public class SysDutyDef implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * dutyCode对应表字段
     */
    public static final String COLUMN_DUTY_CODE = "duty_code";

    /**
     * dutyName对应表字段
     */
    public static final String COLUMN_DUTY_NAME = "duty_name";

    /**
     * dutyType对应表字段
     */
    public static final String COLUMN_DUTY_TYPE = "duty_type";

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
     * dutyLevel对应表字段
     */
    public static final String COLUMN_DUTY_LEVEL = "duty_level";

    /**
     * dutySeq对应表字段
     */
    public static final String COLUMN_DUTY_SEQ = "duty_seq";

    /**
     * remark对应表字段
     */
    public static final String COLUMN_REMARK = "remark";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 职务代码
     */
    public String dutyCode;

    /**
     * 职务名称
     */
    public String dutyName;

    /**
     * 职务套别:见业务字典： DICT_OM_DUTYTYPE
     * 例如科技类，审计类等
     * 实际记录了 字典项的GUID （SYS_DITC_ITEM）
     */
    public String dutyType;

    /**
     * 父职务GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidParents;

    /**
     * 是否叶子节点:取值来自业务菜单：DICT_YON
     */
    public String isleaf;

    /**
     * 子节点数
     */
    public BigDecimal subCount;

    /**
     * 职务层次
     */
    public BigDecimal dutyLevel;

    /**
     * 职务序列:职务的面包屑定位信息
     */
    public String dutySeq;

    /**
     * 备注
     */
    public String remark;

}

