package org.tis.tools.abf.module.sys.entity;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import org.tis.tools.abf.module.sys.entity.enums.SeqnoReset;
import org.tis.tools.core.entity.enums.CommonEnumDeserializer;

import java.io.Serializable;

/**
 * sysSeqno每个SEQ_KEY表示一个序号资源，顺序增加使用序号。
 *
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("sys_seqno")
public class SysSeqno implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * seqName对应表字段
     */
    public static final String COLUMN_SEQ_NAME = "seq_name";

    /**
     * seqKey对应表字段
     */
    public static final String COLUMN_SEQ_KEY = "seq_key";

    /**
     * seqNo对应表字段
     */
    public static final String COLUMN_SEQ_NO = "seq_no";

    /**
     * reset对应表字段
     */
    public static final String COLUMN_RESET = "reset";

    /**
     * resetParams对应表字段
     */
    public static final String COLUMN_RESET_PARAMS = "reset_params";

    /**
     * 序号资源表名称:序号资源的名称，如:柜员660001的交易流水序号资源
     */
    public String seqName;

    /**
     * 序号键值
     */
    @TableId
    public String seqKey;

    /**
     * 序号数:顺序增加的数字
     */
    public BigDecimal seqNo;

    /**
     * 重置方式:来自业务字典： DICT_SYS_RESET
     * 如：
     * 不重置（默认）
     * 按天重置
     * 按周重置
     * 自定义重置周期（按指定时间间隔重置）
     * ...
     */
    @JSONField(deserializeUsing = CommonEnumDeserializer.class)
    private SeqnoReset reset ;

    /**
     * 重置处理参数:重置程序执行时的输入参数，通过本参数指定六重置周期，重置执行时间，重置起始数字等
     */
    public String resetParams;

}

