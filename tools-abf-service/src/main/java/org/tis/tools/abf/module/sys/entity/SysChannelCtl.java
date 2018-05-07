package org.tis.tools.abf.module.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * sysChannelCtl
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_channel_ctl")
public class SysChannelCtl implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * chnCode对应表字段
     */
    public static final String COLUMN_CHN_CODE = "chn_code";

    /**
     * chnName对应表字段
     */
    public static final String COLUMN_CHN_NAME = "chn_name";

    /**
     * chnRemark对应表字段
     */
    public static final String COLUMN_CHN_REMARK = "chn_remark";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier）
     */
    @TableId
    public String guid;

    /**
     * 渠道代码:记录接触系统对应的渠道代码
     */
    public String chnCode;

    /**
     * 渠道名称
     */
    public String chnName;

    /**
     * 渠道备注信息
     */
    public String chnRemark;

}

