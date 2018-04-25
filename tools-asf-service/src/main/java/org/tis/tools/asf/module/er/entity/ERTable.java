package org.tis.tools.asf.module.er.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.List;

/**
 *  ER图中的表对象，如人员表，角色表等等
 *  对应位置：diagram/contents/table
 *  一个表对象中含有多个列组成 {@link ERTable}
 * @author zhaoch
 */
@Data
@TableName("er_table")
public class ERTable {

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_CATEGORY_ID = "category_id";

    public static final String COLUMN_PHYSICAL_NAME = "physical_name";

    public static final String COLUMN_LOGICAL_NAME = "logical_name";

    /**
     * 标识ID
     */
    @TableId
    private String id;

    /**
     * 分类ID
     */
    private String categoryId;

    /**
     * 物理名称，对应表名 如人员表的物理名称为 USER
     */
    private String physicalName;

    /**
     * 逻辑名称，对应表名的解释 如USER表逻辑名称为 人员
     */
    private String logicalName;

    /**
     * 表描述
     */
    @JSONField(name = "description")
    private String desc;

    /**
     * 表字段集合
     */
    @TableField(exist = false)
    private ERColumns columns;

    @TableField(exist = false)
    private List<ERColumn> columnList;


}
