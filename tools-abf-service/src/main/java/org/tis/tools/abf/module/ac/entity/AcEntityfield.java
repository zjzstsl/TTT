package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acEntityfield数据实体的字段（属性）定义表
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_entityfield")
public class AcEntityfield implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * guidEntity对应表字段
     */
    public static final String COLUMN_GUID_ENTITY = "guid_entity";

    /**
     * fieldName对应表字段
     */
    public static final String COLUMN_FIELD_NAME = "field_name";

    /**
     * fieldDesc对应表字段
     */
    public static final String COLUMN_FIELD_DESC = "field_desc";

    /**
     * displayFormat对应表字段
     */
    public static final String COLUMN_DISPLAY_FORMAT = "display_format";

    /**
     * doclistCode对应表字段
     */
    public static final String COLUMN_DOCLIST_CODE = "doclist_code";

    /**
     * checkboxValue对应表字段
     */
    public static final String COLUMN_CHECKBOX_VALUE = "checkbox_value";

    /**
     * fkInputurl对应表字段
     */
    public static final String COLUMN_FK_INPUTURL = "fk_inputurl";

    /**
     * fkFielddesc对应表字段
     */
    public static final String COLUMN_FK_FIELDDESC = "fk_fielddesc";

    /**
     * fkColumnname对应表字段
     */
    public static final String COLUMN_FK_COLUMNNAME = "fk_columnname";

    /**
     * fkTablename对应表字段
     */
    public static final String COLUMN_FK_TABLENAME = "fk_tablename";

    /**
     * descFieldname对应表字段
     */
    public static final String COLUMN_DESC_FIELDNAME = "desc_fieldname";

    /**
     * refType对应表字段
     */
    public static final String COLUMN_REF_TYPE = "ref_type";

    /**
     * fieldType对应表字段
     */
    public static final String COLUMN_FIELD_TYPE = "field_type";

    /**
     * displayOrder对应表字段
     */
    public static final String COLUMN_DISPLAY_ORDER = "display_order";

    /**
     * columnName对应表字段
     */
    public static final String COLUMN_COLUMN_NAME = "column_name";

    /**
     * width对应表字段
     */
    public static final String COLUMN_WIDTH = "width";

    /**
     * defaultValue对应表字段
     */
    public static final String COLUMN_DEFAULT_VALUE = "default_value";

    /**
     * minValue对应表字段
     */
    public static final String COLUMN_MIN_VALUE = "min_value";

    /**
     * maxValue对应表字段
     */
    public static final String COLUMN_MAX_VALUE = "max_value";

    /**
     * lengthValue对应表字段
     */
    public static final String COLUMN_LENGTH_VALUE = "length_value";

    /**
     * precisionValue对应表字段
     */
    public static final String COLUMN_PRECISION_VALUE = "precision_value";

    /**
     * validateType对应表字段
     */
    public static final String COLUMN_VALIDATE_TYPE = "validate_type";

    /**
     * ismodify对应表字段
     */
    public static final String COLUMN_ISMODIFY = "ismodify";

    /**
     * isdisplay对应表字段
     */
    public static final String COLUMN_ISDISPLAY = "isdisplay";

    /**
     * isinput对应表字段
     */
    public static final String COLUMN_ISINPUT = "isinput";

    /**
     * ispk对应表字段
     */
    public static final String COLUMN_ISPK = "ispk";

    /**
     * isautokey对应表字段
     */
    public static final String COLUMN_ISAUTOKEY = "isautokey";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 隶属实体GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidEntity;

    /**
     * 属性名称
     */
    public String fieldName;

    /**
     * 属性描述
     */
    public String fieldDesc;

    /**
     * 显示格式:如：属性为日期时，可以设置显示格式 yyyy/MM/dd；
     * 当查询出数据，返回给调用着之前生效本显示格式（返回的数据已经被格式化）；
     */
    public String displayFormat;

    /**
     * 代码大类
     */
    public String doclistCode;

    /**
     * CHECKBOX_VALUE
     */
    public String checkboxValue;

    /**
     * 外键录入URL
     */
    public String fkInputurl;

    /**
     * 外键描述字段名
     */
    public String fkFielddesc;

    /**
     * 外键列名
     */
    public String fkColumnname;

    /**
     * 外键表名
     */
    public String fkTablename;

    /**
     * 描述字段名
     */
    public String descFieldname;

    /**
     * 引用类型:0 业务字典
     * 1 其他表
     */
    public String refType;

    /**
     * 字段类型:0 字符串
     * 1 整数
     * 2 小数
     * 3 日期
     * 4 日期时间
     * 5 CHECKBOX
     * 6 引用
     */
    public String fieldType;

    /**
     * 顺序
     */
    public BigDecimal displayOrder;

    /**
     * 数据库列名
     */
    public String columnName;

    /**
     * 宽度
     */
    public BigDecimal width;

    /**
     * 缺省值
     */
    public String defaultValue;

    /**
     * 最小值
     */
    public String minValue;

    /**
     * 最大值
     */
    public String maxValue;

    /**
     * 长度
     */
    public BigDecimal lengthValue;

    /**
     * 小数位
     */
    public BigDecimal precisionValue;

    /**
     * 页面校验类型
     */
    public String validateType;

    /**
     * 是否可修改:取值来自业务菜单： DICT_YON
     */
    public String ismodify;

    /**
     * 是否显示:取值来自业务菜单： DICT_YON
     */
    public String isdisplay;

    /**
     * 是否必须填写:取值来自业务菜单： DICT_YON
     */
    public String isinput;

    /**
     * 是否是主键:取值来自业务菜单： DICT_YON
     */
    public String ispk;

    /**
     * 是否自动产生主键:取值来自业务菜单： DICT_YON
     */
    public String isautokey;

}

