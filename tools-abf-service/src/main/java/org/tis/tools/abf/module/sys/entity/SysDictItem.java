package org.tis.tools.abf.module.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * sysDictItem业务字典内容项， 展示下拉菜单结构时，一般需要： 字典项，字典项名称，实际值
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_dict_item")
public class SysDictItem implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * guidDict对应表字段
     */
    public static final String COLUMN_GUID_DICT = "guid_dict";

    /**
     * itemName对应表字段
     */
    public static final String COLUMN_ITEM_NAME = "item_name";

    /**
     * itemType对应表字段
     */
    public static final String COLUMN_ITEM_TYPE = "item_type";

    /**
     * itemValue对应表字段
     */
    public static final String COLUMN_ITEM_VALUE = "item_value";

    /**
     * sendValue对应表字段
     */
    public static final String COLUMN_SEND_VALUE = "send_value";

    /**
     * seqno对应表字段
     */
    public static final String COLUMN_SEQNO = "seqno";

    /**
     * itemDesc对应表字段
     */
    public static final String COLUMN_ITEM_DESC = "item_desc";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 隶属业务字典:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidDict;

    /**
     * 字典项名称
     */
    public String itemName;

    /**
     * 字典项类型:来自 dict 字典、value 实际值
     */
    public String itemType;

    /**
     * 字典项
     */
    public String itemValue;

    /**
     * 实际值:实际值，及选中字典项后，实际发送值给系统的数值。
     */
    public String sendValue;

    /**
     * 顺序号:顺序号，从0开始排，按小到大排序
     */
    public BigDecimal seqno;

    /**
     * 字典项说明
     */
    public String itemDesc;

}

