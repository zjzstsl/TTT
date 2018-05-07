package org.tis.tools.abf.module.om.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * omEmployee人员信息表
 * 人员至少隶属于一个机构；
 * 本表记录了：人员基本信息，人员联系信息，人员在机构中的信息，人员对应的操作员信息集成了人员的多个维度信息一起。
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
@Data
@TableName("om_employee")
public class OmEmployee implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * guid对应表字段
     */
    public static final String COLUMN_GUID = "guid";

    /**
     * empCode对应表字段
     */
    public static final String COLUMN_EMP_CODE = "emp_code";

    /**
     * empName对应表字段
     */
    public static final String COLUMN_EMP_NAME = "emp_name";

    /**
     * empRealname对应表字段
     */
    public static final String COLUMN_EMP_REALNAME = "emp_realname";

    /**
     * gender对应表字段
     */
    public static final String COLUMN_GENDER = "gender";

    /**
     * empstatus对应表字段
     */
    public static final String COLUMN_EMPSTATUS = "empstatus";

    /**
     * guidOrg对应表字段
     */
    public static final String COLUMN_GUID_ORG = "guid_org";

    /**
     * guidPosition对应表字段
     */
    public static final String COLUMN_GUID_POSITION = "guid_position";

    /**
     * guidEmpMajor对应表字段
     */
    public static final String COLUMN_GUID_EMP_MAJOR = "guid_emp_major";

    /**
     * indate对应表字段
     */
    public static final String COLUMN_INDATE = "indate";

    /**
     * outdate对应表字段
     */
    public static final String COLUMN_OUTDATE = "outdate";

    /**
     * mobileno对应表字段
     */
    public static final String COLUMN_MOBILENO = "mobileno";

    /**
     * paperType对应表字段
     */
    public static final String COLUMN_PAPER_TYPE = "paper_type";

    /**
     * paperNo对应表字段
     */
    public static final String COLUMN_PAPER_NO = "paper_no";

    /**
     * birthdate对应表字段
     */
    public static final String COLUMN_BIRTHDATE = "birthdate";

    /**
     * htel对应表字段
     */
    public static final String COLUMN_HTEL = "htel";

    /**
     * haddress对应表字段
     */
    public static final String COLUMN_HADDRESS = "haddress";

    /**
     * hzipcode对应表字段
     */
    public static final String COLUMN_HZIPCODE = "hzipcode";

    /**
     * guidOperator对应表字段
     */
    public static final String COLUMN_GUID_OPERATOR = "guid_operator";

    /**
     * userId对应表字段
     */
    public static final String COLUMN_USER_ID = "user_id";

    /**
     * remark对应表字段
     */
    public static final String COLUMN_REMARK = "remark";

    /**
     * 数据主键:全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成；
     */
    @TableId
    public String guid;

    /**
     * 员工代码
     */
    public String empCode;

    /**
     * 员工姓名
     */
    public String empName;

    /**
     * 员工全名
     */
    public String empRealname;

    /**
     * 性别:见业务菜单：DICT_OM_GENDER
     */
    public String gender;

    /**
     * 员工状态:见业务字典： DICT_OM_EMPSTATUS
     */
    public String empstatus;

    /**
     * 主机构编号:人员所属主机构编号（冗余设计）
     */
    public String guidOrg;

    /**
     * 基本岗位
     */
    public String guidPosition;

    /**
     * 直接主管
     */
    public String guidEmpMajor;

    /**
     * 入职日期
     */
    public Date indate;

    /**
     * 离职日期
     */
    public Date outdate;

    /**
     * 手机号码
     */
    public String mobileno;

    /**
     * 证件类型:见业务字典： DICT_SD_PAPERTYPE
     */
    public String paperType;

    /**
     * 证件号码
     */
    public String paperNo;

    /**
     * 出生日期
     */
    public Date birthdate;

    /**
     * 家庭电话
     */
    public String htel;

    /**
     * 家庭地址
     */
    public String haddress;

    /**
     * 家庭邮编:见业务字典： DICT_SD_ZIPCODE
     */
    public String hzipcode;

    /**
     * 操作员编号
     */
    public String guidOperator;

    /**
     * 操作员:登陆用户id
     */
    public String userId;

    /**
     * 备注
     */
    public String remark;

}

