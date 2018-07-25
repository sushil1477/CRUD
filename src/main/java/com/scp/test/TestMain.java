package com.scp.test;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;

import com.scp.constants.AppLevelConstants;
import com.scp.constants.AppLevelConstants.EmpFields;
import com.scp.entity.Employee;
import com.scp.pojo.EmpPojo;
import com.scp.service.EmpService;
import com.scp.service.impl.EmpServiceImpl;

public class TestMain {
	
			public static Logger logger=Logger.getLogger(TestMain.class);
			
			
	public static void main(String[] args) {
		
			  
		logger.setLevel(Level.ALL);
		
		for (int i=0;i<5;i++){
			
			logger.fatal("this is fatal");
			logger.trace("this is trace");
			logger.error("this is error");
			logger.info("this is info");
		}
		
		if(true)
			return;
		
		EmpPojo emp1=new EmpPojo(10,"sushil","admin",true);
		EmpPojo emp2=new EmpPojo(11,"user2","admin1",false);       //OFE WI DTA
		EmpService empservice=new EmpServiceImpl();
		
		System.out.println("------------SAVE-------------");
		boolean empObj=empservice.addEmp(emp1);
		empObj=empservice.addEmp(emp2);
		System.out.println("object is added"+ empObj);
		
		System.out.println("--------GETList------------");
		List<EmpPojo> listOfPojos=empservice.getAllEmps();
		System.out.println("list of pojos"+ listOfPojos);
		
		HashMap<EmpFields,String> hmap=new HashMap<AppLevelConstants.EmpFields,String>();
		hmap.put(EmpFields.empUserName,"sushil");
		hmap.put(EmpFields.empPassword,"admin");
		
		 listOfPojos=empservice.searchEmp(hmap);
		 System.out.println("List By search criteria"+listOfPojos);
	}
	
}
