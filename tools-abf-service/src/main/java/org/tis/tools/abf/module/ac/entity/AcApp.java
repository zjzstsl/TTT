package org.tis.tools.abf.module.ac.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * acApp应用系统（Application）注册表
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("ac_app")
public class AcApp implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * appCode对应表字段
     */
    public static final String COLUMN_APP_CODE = "app_code";

    /**
     * appName对应表字段
     */
    public static final String COLUMN_APP_NAME = "app_name";

    /**
     * appType对应表字段
     */
    public static final String COLUMN_APP_TYPE = "app_type";

    /**
     * isopen对应表字段
     */
    public static final String COLUMN_ISOPEN = "isopen";

    /**
     * openDate对应表字段
     */
    public static final String COLUMN_OPEN_DATE = "open_date";

    /**
     * url对应表字段
     */
    public static final String COLUMN_URL = "url";

    /**
     * ipAddr对应表字段
     */
    public static final String COLUMN_IP_ADDR = "ip_addr";

    /**
     * ipPort对应表字段
     */
    public static final String COLUMN_IP_PORT = "ip_port";

    /**
     * appDesc对应表字段
     */
    public static final String COLUMN_APP_DESC = "app_desc";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 应用代码
     */
    public String appCode;

    /**
     * 应用名称
     */
    public String appName;

    /**
     * 应用类型:取值来自业务菜单： DICT_AC_APPTYPE
     * 如：本地，远程
     */
    public String appType;

    /**
     * 是否开通:取值来自业务菜单： DICT_YON
     * 默认为N，新建后，必须执行应用开通操作，才被开通。
     */
    public String isopen;

    /**
     * 开通时间:记录到时分秒
     */
    public Date openDate;

    /**
     * 访问地址:http://IP:PORT/service-name
     */
    public String url;

    /**
     * IP
     */
    public String ipAddr;

    /**
     * 端口
     */
    public String ipPort;

    /**
     * 应用描述
     */
    public String appDesc;

}

