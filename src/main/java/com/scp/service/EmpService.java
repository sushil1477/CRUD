package com.scp.service;

import java.util.HashMap;
import java.util.List;

import com.scp.constants.AppLevelConstants;
import com.scp.pojo.EmpPojo;

public interface EmpService {

	public boolean addEmp(EmpPojo emp);//adds employee object 
	public boolean deleteEmp(int empId);
	public EmpPojo getEmp(int empId);//gives emp obj
	public boolean updateEmp(EmpPojo emp);//
	public List<EmpPojo> getAllEmps();//returns list of all employees
	public List<EmpPojo> searchEmp(HashMap<AppLevelConstants.EmpFields,String> searchCriteria);
	//hashmap accepts value as constants (as employee fields)
}
