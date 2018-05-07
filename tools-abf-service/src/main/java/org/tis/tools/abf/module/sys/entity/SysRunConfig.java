package org.tis.tools.abf.module.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * sysRunConfig运行期系统参数表，以三段式结构进行参数存储
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_run_config")
public class SysRunConfig implements Serializable {

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
     * groupName对应表字段
     */
    public static final String COLUMN_GROUP_NAME = "group_name";

    /**
     * keyName对应表字段
     */
    public static final String COLUMN_KEY_NAME = "key_name";

    /**
     * valueFrom对应表字段
     */
    public static final String COLUMN_VALUE_FROM = "value_from";

    /**
     * value对应表字段
     */
    public static final String COLUMN_VALUE = "value";

    /**
     * description对应表字段
     */
    public static final String COLUMN_DESCRIPTION = "description";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 应用系统GUID:用于表识一组参数属于某个应用系统 。下拉AC_APP表记录
     */
    public String guidApp;

    /**
     * 参数组别:参数组别，手工输入
     */
    public String groupName;

    /**
     * 参数键:参数键名称，手工输入
     */
    public String keyName;

    /**
     * 值来源类型:H：手工指定
     * 或者选择业务字典的GUID（此时存储业务字典名称 SYS_DICT.DICT_KEY)
     */
    public String valueFrom;

    /**
     * 参数值:当value_from为H时，手工输入任意有效字符串；
     * 当value_from为业务字典时，下拉选择；
     */
    public String value;

    /**
     * 参数描述:参数功能描述
     */
    public String description;

}

