package org.tis.tools.abf.module.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * sysErrCode记录系统中的各种错误代码信息，如系统抛出的错误信息，交易执行时的错误码等
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_err_code")
public class SysErrCode implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * errcodeKind对应表字段
     */
    public static final String COLUMN_ERRCODE_KIND = "errcode_kind";

    /**
     * errCode对应表字段
     */
    public static final String COLUMN_ERR_CODE = "err_code";

    /**
     * errMsg对应表字段
     */
    public static final String COLUMN_ERR_MSG = "err_msg";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier）
     */
    @TableId
    public String guid;

    /**
     * 错误代码分类:见业务字典： DICT_ERRCODE_KIND
     * SYS 系统错误码
     * TRANS 交易错误码
     */
    public String errcodeKind;

    /**
     * 错误代码
     */
    public String errCode;

    /**
     * 错误信息
     */
    public String errMsg;

}

