package com.scp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	private int empId;
	private String empUserName;
	private String empPassword;
	private String isActive;
	
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
	public String isActive() {
		return isActive;
	}
	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	public Employee(int empId, String empUserName, String empPassword, String isActive) {
		super();
		this.empId = empId;
		this.empUserName = empUserName;
		this.empPassword = empPassword;
		this.isActive = isActive;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n Employee [empId=" + empId + ", empUserName=" + empUserName + ", empPassword=" + empPassword
				+ ", isActive=" + isActive + "]";
	}
	
}
