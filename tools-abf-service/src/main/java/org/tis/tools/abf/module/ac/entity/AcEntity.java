package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acEntity数据实体定义表
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_entity")
public class AcEntity implements Serializable {

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
     * entityName对应表字段
     */
    public static final String COLUMN_ENTITY_NAME = "entity_name";

    /**
     * entityDesc对应表字段
     */
    public static final String COLUMN_ENTITY_DESC = "entity_desc";

    /**
     * tableName对应表字段
     */
    public static final String COLUMN_TABLE_NAME = "table_name";

    /**
     * entityType对应表字段
     */
    public static final String COLUMN_ENTITY_TYPE = "entity_type";

    /**
     * isadd对应表字段
     */
    public static final String COLUMN_ISADD = "isadd";

    /**
     * isdel对应表字段
     */
    public static final String COLUMN_ISDEL = "isdel";

    /**
     * ismodify对应表字段
     */
    public static final String COLUMN_ISMODIFY = "ismodify";

    /**
     * isview对应表字段
     */
    public static final String COLUMN_ISVIEW = "isview";

    /**
     * ispage对应表字段
     */
    public static final String COLUMN_ISPAGE = "ispage";

    /**
     * pageSize对应表字段
     */
    public static final String COLUMN_PAGE_SIZE = "page_size";

    /**
     * refRelation对应表字段
     */
    public static final String COLUMN_REF_RELATION = "ref_relation";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 隶属应用GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidApp;

    /**
     * 实体名称
     */
    public String entityName;

    /**
     * 实体描述
     */
    public String entityDesc;

    /**
     * 数据库表名
     */
    public String tableName;

    /**
     * 实体类型:取值来自业务字典：DICT_AC_ENTITYTYPE
     * 0-表
     * 1-视图
     * 2-查询实体
     * 3-内存对象（系统运行时才存在）
     */
    public String entityType;

    /**
     * 是否可增加:取值来自业务菜单： DICT_YON
     */
    public String isadd;

    /**
     * 是否可删除:取值来自业务菜单： DICT_YON
     */
    public String isdel;

    /**
     * 可修改:取值来自业务菜单： DICT_YON
     */
    public String ismodify;

    /**
     * 可查看:取值来自业务菜单： DICT_YON
     */
    public String isview;

    /**
     * 是否需要分页显示:取值来自业务菜单： DICT_YON
     */
    public String ispage;

    /**
     * 每页记录数
     */
    public BigDecimal pageSize;

    /**
     * 引用关系:根据引用关系定义，检查关联记录是否需要同步删除；
     * 引用关系定义格式： table.column/[Y/N];table.column/[Y/N];...
     * 举例：
     * 假如，存在实体acct，且引用关系定义如下
     * 
     * guid:tws_abc.acct_guid/Y;tws_nnn.acctid/N;
     * 
     * 当前删除acct实体guid＝9988的记录，系统自动执行引用关系删除，逻辑如下：
     * 查找tws_abc 表，acct_guid = 9988 的记录，并删除；
     * 查找tws_nnn 表，acctid=9988的记录，但不删除；
     * 
     * 如果采用系统默认的命名方式，规则可以简化为：
     * guid:tws_abc/Y;tws_nnn/N;
     * 则
     * 查找tws_abc 表，acct_guid = 9988 的记录，并删除；
     * 查找tws_nnn 表，acct_guid = 9988 的记录，但不删除；
     * 
     * 前提，必须基于实体的GUID进行引用。
     */
    public String refRelation;

}

