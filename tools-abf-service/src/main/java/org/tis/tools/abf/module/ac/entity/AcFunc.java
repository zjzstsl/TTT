package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acFunc功能&行为，菜单
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_func")
public class AcFunc implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * guidApp对应表字段
     */
    public static final String COLUMN_GUID_APP = "guid_app";

    /**
     * funcType对应表字段
     */
    public static final String COLUMN_FUNC_TYPE = "func_type";

    /**
     * funcCode对应表字段
     */
    public static final String COLUMN_FUNC_CODE = "func_code";

    /**
     * funcName对应表字段
     */
    public static final String COLUMN_FUNC_NAME = "func_name";

    /**
     * funcDesc对应表字段
     */
    public static final String COLUMN_FUNC_DESC = "func_desc";

    /**
     * isopen对应表字段
     */
    public static final String COLUMN_ISOPEN = "isopen";

    /**
     * ischeck对应表字段
     */
    public static final String COLUMN_ISCHECK = "ischeck";

    /**
     * guidFunc对应表字段
     */
    public static final String COLUMN_GUID_FUNC = "guid_func";

    /**
     * displayOrder对应表字段
     */
    public static final String COLUMN_DISPLAY_ORDER = "display_order";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 隶属应用:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidApp;

    /**
     * 功能类型:取值来自业务菜单：DICT_AC_FUNCTYPE
     * F：功能（Function）
     * B：行为（Behave）
     */
    public String funcType;

    /**
     * 功能编号:业务上对功能的编码
     */
    public String funcCode;

    /**
     * 功能名称
     */
    public String funcName;

    /**
     * 功能描述
     */
    public String funcDesc;

    /**
     * 是否启用:Y 启用(默认）
     * N 停用（不出现在菜单中）
     */
    public String isopen;

    /**
     * 是否验证权限:取值来自业务菜单： DICT_YON
     * N：无需验权（只要有看见菜单，所有人都能执行本功能）
     * Y：需进行权限验证（默认）
     */
    public String ischeck;

    /**
     * 父:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidFunc;

    /**
     * 显示顺序:所在层次内的展示顺序
     */
    public BigDecimal displayOrder;

}

