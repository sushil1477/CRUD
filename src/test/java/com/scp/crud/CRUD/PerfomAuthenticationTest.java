package com.scp.crud.CRUD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.empBusiness.EmpController;
import com.scp.util.ReadDataFromExcelUtil;

import junit.framework.Assert;

public class PerfomAuthenticationTest {

	
	@DataProvider
	public Object[][] getTestData(){
		return  ReadDataFromExcelUtil.readTestData();
		
	}
	@Test(dataProvider="getTestData")
	public void perforLogin(String uname,String pwd,String emsg){
		System.out.println(uname +"----" +pwd +" ---" +emsg);
		EmpController empC=new EmpController();
		String actualMsg=empC.validCredentials(uname, pwd);
		Assert.assertEquals(actualMsg, emsg);
		
	}
	
}
