package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acOperatorMenu操作员对自己在某个应用系统的菜单重组
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_operator_menu")
public class AcOperatorMenu implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * guidOperator对应表字段
     */
    public static final String COLUMN_GUID_OPERATOR = "guid_operator";

    /**
     * guidApp对应表字段
     */
    public static final String COLUMN_GUID_APP = "guid_app";

    /**
     * guidFunc对应表字段
     */
    public static final String COLUMN_GUID_FUNC = "guid_func";

    /**
     * menuName对应表字段
     */
    public static final String COLUMN_MENU_NAME = "menu_name";

    /**
     * menuLabel对应表字段
     */
    public static final String COLUMN_MENU_LABEL = "menu_label";

    /**
     * guidParents对应表字段
     */
    public static final String COLUMN_GUID_PARENTS = "guid_parents";

    /**
     * isleaf对应表字段
     */
    public static final String COLUMN_ISLEAF = "isleaf";

    /**
     * uiEntry对应表字段
     */
    public static final String COLUMN_UI_ENTRY = "ui_entry";

    /**
     * menuLevel对应表字段
     */
    public static final String COLUMN_MENU_LEVEL = "menu_level";

    /**
     * guidRoot对应表字段
     */
    public static final String COLUMN_GUID_ROOT = "guid_root";

    /**
     * displayOrder对应表字段
     */
    public static final String COLUMN_DISPLAY_ORDER = "display_order";

    /**
     * imagePath对应表字段
     */
    public static final String COLUMN_IMAGE_PATH = "image_path";

    /**
     * expandPath对应表字段
     */
    public static final String COLUMN_EXPAND_PATH = "expand_path";

    /**
     * menuSeq对应表字段
     */
    public static final String COLUMN_MENU_SEQ = "menu_seq";

    /**
     * openMode对应表字段
     */
    public static final String COLUMN_OPEN_MODE = "open_mode";

    /**
     * subCount对应表字段
     */
    public static final String COLUMN_SUB_COUNT = "sub_count";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 操作员GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidOperator;

    /**
     * 适用于应用
     */
    public String guidApp;

    /**
     * 功能GUID
     */
    public String guidFunc;

    /**
     * 菜单名称:显示为菜单的名称
     */
    public String menuName;

    /**
     * 菜单显示（中文）
     */
    public String menuLabel;

    /**
     * 父菜单GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidParents;

    /**
     * 是否叶子菜单:见业务菜单： DICT_YON
     */
    public String isleaf;

    /**
     * UI入口:针对EXT模式提供，例如abf_auth/function/module.xml
     */
    public String uiEntry;

    /**
     * 菜单层次:原类型smallint
     */
    public BigDecimal menuLevel;

    /**
     * 根菜单GUID
     */
    public String guidRoot;

    /**
     * 显示顺序:原类型smallint
     */
    public BigDecimal displayOrder;

    /**
     * 菜单图片路径
     */
    public String imagePath;

    /**
     * 菜单展开图片路径
     */
    public String expandPath;

    /**
     * 菜单路径序列
     */
    public String menuSeq;

    /**
     * 页面打开方式:数值取自业务菜单： DICT_AC_OPENMODE
     * 如：主窗口打开、弹出窗口打开...
     */
    public String openMode;

    /**
     * 子节点数
     */
    public BigDecimal subCount;

}

