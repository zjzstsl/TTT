package org.tis.tools.abf.module.ac.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acRole权限集（角色）定义表
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_role")
public class AcRole implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * roleCode对应表字段
     */
    public static final String COLUMN_ROLE_CODE = "role_code";

    /**
     * roleName对应表字段
     */
    public static final String COLUMN_ROLE_NAME = "role_name";

    /**
     * guidApp对应表字段
     */
    public static final String COLUMN_GUID_APP = "guid_app";

    /**
     * enabled对应表字段
     */
    public static final String COLUMN_ENABLED = "enabled";

    /**
     * roleDesc对应表字段
     */
    public static final String COLUMN_ROLE_DESC = "role_desc";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 角色代码:业务上对角色的编码
     */
    public String roleCode;

    /**
     * 角色名称
     */
    public String roleName;

    /**
     * 隶属应用GUID
     */
    public String guidApp;

    /**
     * 是否启用
     */
    public String enabled;

    /**
     * 角色描述
     */
    public String roleDesc;

}

