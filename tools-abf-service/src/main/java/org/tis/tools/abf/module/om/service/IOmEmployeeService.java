package org.tis.tools.abf.module.om.service;

import com.baomidou.mybatisplus.service.IService;
import org.tis.tools.abf.module.om.controller.request.OmEmployeeAddRequest;
import org.tis.tools.abf.module.om.entity.OmEmployee;
import org.tis.tools.abf.module.om.exception.OrgManagementException;

/**
 * omEmployee的Service接口类
 * 
 * @author Auto Generate Tools
 * @date 2018/04/23
 */
public interface IOmEmployeeService extends IService<OmEmployee>  {

    /**
     * <pre>
     * 新增员工（指定最少必要数据）
     * 一般在快速员工新增时调用，如：向导式新增员工时，输入最少必要字段后，即可新增员工，后续步骤再完善员工资料。
     *
     * 说明：
     * 系统自动补充员工状态等必要数据；
     * </pre>
     *
     * @param empCode 员工代码
     * @param empName 员工姓名
     * @param empRealname 员工全名
     * @param gender 性别（值必须来自业务字典： DICT_OM_GENDER）
     * @param empstatus 员工状态（值必须来自业务字典： DICT_OM_EMPSTATUS）
     * @param guidOrg 主机构编号
     * @param guidPosition 基本岗位
     * @return
     * @throws OrgManagementException
     */
    OmEmployee createEmployee(String empCode,String empName,String empRealname,String gender,String empstatus,String guidOrg,String guidPosition)
            throws OrgManagementException;

    /**
     * <pre>
     * 修改员工信息
     *
     * 说明：
     * 只修改传入对象（newEmployee）上有值的字段；
     * 并且程序避免对（逻辑上）不可直接修改字段的更新，如：员工状态不能直接通过修改而更新；
     * </pre>
     *
     * @param newEmployee
     *            跟新后的员工信息
     * @return 修改后的员工信息
     * @throws OrgManagementException
     */
    OmEmployee updateEmployee(String guid,String empCode,String empName,String empRealname,String gender,String empstatus,String guidOrg,String guidPosition)
            throws OrgManagementException;

    /**
     * <pre>
     * 删除员工（empCode）
     *
     * 说明：
     * 只有处于‘在招’状态的员工才能被删除；
     * 系统清理于该员工有关的所有映射关系表，包括：OM_EMP_ORG、OM_EMP_POSITION、OM_EMP_GROUP ...
     * </pre>
     *
     * @param empCode
     *            员工代码
     * @return 被删除的员工信息
     * @throws OrgManagementException
     */
    OmEmployee deleteEmployee(String guid) throws OrgManagementException;

    /**
     * <pre>
     * 根据员工代码（empCode）查询员工列表明细信息
     * </pre>
     *
     * @param guid
     *            数据主键
     * @return 员工信息
     */
    OmEmployee queryEmployeeBrief(String guid) throws OrgManagementException;

    /**
     * <pre>
     * 根据员工代码（empCode）查询员工摘要信息
     * </pre>
     *
     * @param guid
     *            数据主键
     * @return 员工信息
     */
    OmEmployee queryEmployeeDetail(String guid) throws OrgManagementException;

    /**
     * <pre>
     * 新增员工岗位
     * </pre>
     *
     * @param guid 员工主键
     * @param guidPosition 基本岗位
     * @return
     * @throws OrgManagementException
     */
    OmEmployee assignPosition(String guid,String guidPosition) throws OrgManagementException;

    /**
     * <pre>
     * 新增员工岗位
     * </pre>
     *
     * @param guid 员工主键
     * @param guidOrg 基本机构
     * @return
     * @throws OrgManagementException
     */
    OmEmployee assignOrg(String guid,String guidOrg) throws OrgManagementException;

    /**
     * <pre>
     * 修改员工操作员
     * </pre>
     *
     * @param newEmployee
     *            跟新后的员工信息
     * @return 修改后的员工信息
     * @throws OrgManagementException
     */
    OmEmployee updateEmployeeUserId(String guid,String userId) throws OrgManagementException;

    /**
     * <pre>
     * 修改员工状态
     * </pre>
     *
     * @param newEmployee
     *            跟新后的员工信息
     * @return 修改后的员工信息
     * @throws OrgManagementException
     */
    OmEmployee changeEmpStatus(String guid,String empStatus) throws OrgManagementException;
}

