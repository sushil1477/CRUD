package com.scp.pojo;

public class EmpPojo {

	private int empId;
	private String empUserName;
	private String empPassword;
	private boolean isActive;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpUserName() {
		return empUserName;
	}
	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public EmpPojo(int empId, String empUserName, String empPassword, Boolean isActive) {
		super();
		this.empId = empId;
		this.empUserName = empUserName;
		this.empPassword = empPassword;
		this.isActive = isActive;
	}
	public EmpPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n EmpPojo [empId=" + empId + ", empUserName=" + empUserName + ", empPassword=" + empPassword
				+ ", isActive=" + isActive + "]";
	}
	
	
	
}
