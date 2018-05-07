package org.tis.tools.abf.module.ac.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acOperator系统登录用户表，一个用户只能有一个或零个操作员
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_operator")
public class AcOperator implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * userId对应表字段
     */
    public static final String COLUMN_USER_ID = "user_id";

    /**
     * password对应表字段
     */
    public static final String COLUMN_PASSWORD = "password";

    /**
     * operatorName对应表字段
     */
    public static final String COLUMN_OPERATOR_NAME = "operator_name";

    /**
     * operatorStatus对应表字段
     */
    public static final String COLUMN_OPERATOR_STATUS = "operator_status";

    /**
     * invalDate对应表字段
     */
    public static final String COLUMN_INVAL_DATE = "inval_date";

    /**
     * authMode对应表字段
     */
    public static final String COLUMN_AUTH_MODE = "auth_mode";

    /**
     * lockLimit对应表字段
     */
    public static final String COLUMN_LOCK_LIMIT = "lock_limit";

    /**
     * errCount对应表字段
     */
    public static final String COLUMN_ERR_COUNT = "err_count";

    /**
     * lockTime对应表字段
     */
    public static final String COLUMN_LOCK_TIME = "lock_time";

    /**
     * unlockTime对应表字段
     */
    public static final String COLUMN_UNLOCK_TIME = "unlock_time";

    /**
     * lastLogin对应表字段
     */
    public static final String COLUMN_LAST_LOGIN = "last_login";

    /**
     * startDate对应表字段
     */
    public static final String COLUMN_START_DATE = "start_date";

    /**
     * endDate对应表字段
     */
    public static final String COLUMN_END_DATE = "end_date";

    /**
     * validTime对应表字段
     */
    public static final String COLUMN_VALID_TIME = "valid_time";

    /**
     * macCode对应表字段
     */
    public static final String COLUMN_MAC_CODE = "mac_code";

    /**
     * ipAddress对应表字段
     */
    public static final String COLUMN_IP_ADDRESS = "ip_address";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 登录用户名
     */
    public String userId;

    /**
     * 密码
     */
    public String password;

    /**
     * 操作员姓名:记录当前操作员姓名（只记录当前值，不随之改变）
     */
    public String operatorName;

    /**
     * 操作员状态:取值来自业务菜单：DICT_AC_OPERATOR_STATUS
     * 正常，挂起，注销，锁定...
     * 系统处理状态间的流转
     */
    public String operatorStatus;

    /**
     * 密码失效日期:指定失效时间具体到时分秒
     */
    public Date invalDate;

    /**
     * 认证模式:取值来自业务菜单：DICT_AC_AUTHMODE
     * 如：本地密码认证、LDAP认证、等
     * 可以多选，以逗号分隔，且按照出现先后顺序进行认证；
     * 如：
     * pwd,captcha
     * 表示输入密码，并且还需要验证码
     */
    public String authMode;

    /**
     * 锁定次数限制:登陆错误超过本数字，系统锁定操作员，默认5次。
     * 可为操作员单独设置；
     */
    public BigDecimal lockLimit;

    /**
     * 当前错误登录次数
     */
    public BigDecimal errCount;

    /**
     * 锁定时间
     */
    public Date lockTime;

    /**
     * 解锁时间:当状态为锁定时，解锁的时间
     */
    public Date unlockTime;

    /**
     * 最近登录时间
     */
    public Date lastLogin;

    /**
     * 有效开始日期:启用操作员时设置，任何时间可设置；
     */
    public Date startDate;

    /**
     * 有效截止日期:启用操作员时设置，任何时间可设置；
     */
    public Date endDate;

    /**
     * 允许时间范围:定义一个规则表达式，表示允许操作的有效时间范围，格式为：
     * [{begin:"HH:mm",end:"HH:mm"},{begin:"HH:mm",end:"HH:mm"},...]
     * 如：
     * [{begin:"08:00",end:"11:30"},{begin:"14:30",end:"17:00"}]
     * 表示，该操作员被允许每天有两个时间段进行系统操作，分别 早上08:00 - 11:30，下午14:30 － 17:00
     */
    public String validTime;

    /**
     * 允许MAC码:允许设置多个MAC，以逗号分隔，控制操作员只能在这些机器上登陆。
     */
    public String macCode;

    /**
     * 允许IP地址:允许设置多个IP地址
     */
    public String ipAddress;

}

