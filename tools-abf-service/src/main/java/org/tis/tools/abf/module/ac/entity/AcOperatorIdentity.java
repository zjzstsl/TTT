package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acOperatorIdentity操作员对自己的权限进行组合形成一个固定的登录身份；
 * 供登录时选项，每一个登录身份是员工操作员的权限子集；
 * 登陆应用系统时，可以在权限子集间选择，如果不指定，则采用默认身份登陆。
 * （可基于本表扩展支持：根据登陆渠道返回操作员的权限）
 * 可以没有身份，不指定身份登陆时，表示使用操作所有角色、功能权限
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_operator_identity")
public class AcOperatorIdentity implements Serializable {

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
     * identityName对应表字段
     */
    public static final String COLUMN_IDENTITY_NAME = "identity_name";

    /**
     * identityFlag对应表字段
     */
    public static final String COLUMN_IDENTITY_FLAG = "identity_flag";

    /**
     * guidApp对应表字段
     */
    public static final String COLUMN_GUID_APP = "guid_app";

    /**
     * seqNo对应表字段
     */
    public static final String COLUMN_SEQ_NO = "seq_no";

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
     * 身份名称
     */
    public String identityName;

    /**
     * 默认身份标志:见业务字典： DICT_YON
     * 只能有一个默认身份 Y是默认身份 N不是默认身份
     */
    public String identityFlag;

    /**
     * 适用于应用
     */
    public String guidApp;

    /**
     * 显示顺序
     */
    public BigDecimal seqNo;

}

