/**
 * 
 */
package org.tis.tools.abf.module.om.exception;


import org.tis.tools.core.exception.ToolsRuntimeException;

/**
 * 
 * 机构管理服务异常对象
 * 
 * @author megapro
 *
 */
public class OrgManagementException extends ToolsRuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrgManagementException(){
		
	};

	public OrgManagementException(String code) {
		super(code);
	}
	
	public OrgManagementException(String code, Object[] placeholders) {
		super(code,placeholders) ;
	}
	
	public OrgManagementException(String code, Object[] params, String message) {
		super(code,params,message) ;
	}

	public OrgManagementException(String code, String message) {
		super(code,message) ;
	}


}
