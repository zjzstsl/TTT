package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acMenu应用菜单表，从逻辑上为某个应用系统中的功能组织为一个有分类，有层级的树结构。
 * UI可根据菜单数据结构，进行界面呈现（PC上，PAD上，手机上....充分考虑用户交互体验）
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_menu")
public class AcMenu implements Serializable {

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
     * menuCode对应表字段
     */
    public static final String COLUMN_MENU_CODE = "menu_code";

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
     * guidParents对应表字段
     */
    public static final String COLUMN_GUID_PARENTS = "guid_parents";

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
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 应用GUID
     */
    public String guidApp;

    /**
     * 功能GUID
     */
    public String guidFunc;

    /**
     * 菜单名称:菜单树上显示的名称，一般同功能名称
     */
    public String menuName;

    /**
     * 菜单显示（中文）
     */
    public String menuLabel;

    /**
     * 菜单代码:业务上对本菜单记录的编码
     */
    public String menuCode;

    /**
     * 是否叶子菜单:数值取自业务菜单：DICT_YON
     */
    public String isleaf;

    /**
     * UI入口:针对EXT模式提供，例如abf_auth/function/module.xml
     */
    public String uiEntry;

    /**
     * 菜单层次:原类型smalint
     */
    public BigDecimal menuLevel;

    /**
     * 父菜单GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidParents;

    /**
     * 根菜单GUID:本菜单所在菜单树的根节点菜单GUID
     */
    public String guidRoot;

    /**
     * 显示顺序:原类型smalint
     */
    public BigDecimal displayOrder;

    /**
     * 菜单闭合图片路径
     */
    public String imagePath;

    /**
     * 菜单展开图片路径
     */
    public String expandPath;

    /**
     * 菜单路径序列:类似面包屑导航，可以看出菜单的全路径；
     * 从应用系统开始，系统自动维护，如： /teller/loan/TX010112
     * 表示柜面系统（teller）中贷款功能组（loan）中的TX010112功能（交易）
     */
    public String menuSeq;

    /**
     * 页面打开方式:数值取自业务菜单： DICT_AC_OPENMODE
     * 如：主窗口打开、弹出窗口打开...
     */
    public String openMode;

}

