package com.scp.empBusiness;

import java.util.List;

import com.scp.constants.AppLevelConstants;
import com.scp.pojo.EmpPojo;
import com.scp.service.EmpService;
import com.scp.service.impl.EmpServiceImpl;

public class EmpController {
	
	public String validCredentials(String userName,String password){
		String dbUserName=null;
		String dbPassword=null;
		try{
		EmpService service=new EmpServiceImpl();
				List<EmpPojo>emps=service.getAllEmps();
				System.out.println(":::::::::::::::"+emps);
				//System.out.println("user list :"+emps);
				for(EmpPojo empPojo:emps){
						dbUserName=empPojo.getEmpUserName();
						dbPassword=empPojo.getEmpPassword();
						break;
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (dbUserName==null){
				dbUserName="";
			}
			if(dbPassword==null){
				dbPassword="";
			}
		}
		
		if(userName==null){
			return AppLevelConstants.USERNAME_CANNOT_BE_EMPTY;
		}else if(password==null){
			return AppLevelConstants.PASSWORD_CANNOT_BE_EMPTY;
		}else if(dbUserName.equals(userName)&& dbPassword.equals(password)){
			return AppLevelConstants.LOGIN_SUCCESS;
		}
		return AppLevelConstants.INVALID_USERNAME_PASSWORD;
	}

}
