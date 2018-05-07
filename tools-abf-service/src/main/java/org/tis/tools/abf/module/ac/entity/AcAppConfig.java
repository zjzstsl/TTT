package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acAppConfig应用个性化配置项
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_app_config")
public class AcAppConfig implements Serializable {

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
     * configType对应表字段
     */
    public static final String COLUMN_CONFIG_TYPE = "config_type";

    /**
     * configName对应表字段
     */
    public static final String COLUMN_CONFIG_NAME = "config_name";

    /**
     * configDict对应表字段
     */
    public static final String COLUMN_CONFIG_DICT = "config_dict";

    /**
     * configStyle对应表字段
     */
    public static final String COLUMN_CONFIG_STYLE = "config_style";

    /**
     * configValue对应表字段
     */
    public static final String COLUMN_CONFIG_VALUE = "config_value";

    /**
     * enabled对应表字段
     */
    public static final String COLUMN_ENABLED = "enabled";

    /**
     * displayOrder对应表字段
     */
    public static final String COLUMN_DISPLAY_ORDER = "display_order";

    /**
     * configDesc对应表字段
     */
    public static final String COLUMN_CONFIG_DESC = "config_desc";

    /**
     * 数据主键
     */
    @TableId
    public String guid;

    /**
     * 应用GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidApp;

    /**
     * 配置类型
     */
    public String configType;

    /**
     * 配置名
     */
    public String configName;

    /**
     * 配置值字典
     */
    public String configDict;

    /**
     * 配置风格
     */
    public String configStyle;

    /**
     * 默认配置值
     */
    public String configValue;

    /**
     * 是否启用
     */
    public String enabled;

    /**
     * 显示顺序:所在层次内的展示顺序
     */
    public BigDecimal displayOrder;

    /**
     * 配置描述说明
     */
    public String configDesc;

}

