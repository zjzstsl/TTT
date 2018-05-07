package org.tis.tools.abf.module.ac.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acDatascope定义能够操作某个表数据的范围
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_datascope")
public class AcDatascope implements Serializable {

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
     * privName对应表字段
     */
    public static final String COLUMN_PRIV_NAME = "priv_name";

    /**
     * dataOpType对应表字段
     */
    public static final String COLUMN_DATA_OP_TYPE = "data_op_type";

    /**
     * entityName对应表字段
     */
    public static final String COLUMN_ENTITY_NAME = "entity_name";

    /**
     * filterSqlString对应表字段
     */
    public static final String COLUMN_FILTER_SQL_STRING = "filter_sql_string";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 实体GUID:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    public String guidEntity;

    /**
     * 数据范围权限名称
     */
    public String privName;

    /**
     * 数据操作类型:取值来自业务菜单：DICT_AC_DATAOPTYPE
     * 对本数据范围内的数据，可以做哪些操作：增加、修改、删除、查询
     * 如果为空，表示都不限制；
     * 多个操作用逗号分隔，如： 增加,修改,删除
     */
    public String dataOpType;

    /**
     * 实体名称
     */
    public String entityName;

    /**
     * 过滤SQL:例： (orgSEQ IS NULL or orgSEQ like '$[SessionEntity/orgSEQ]%') 
     * 通过本SQL，限定了数据范围
     */
    public String filterSqlString;

}

