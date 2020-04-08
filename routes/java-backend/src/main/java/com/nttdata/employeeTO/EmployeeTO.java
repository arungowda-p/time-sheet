package com.nttdata.employeeTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeTO {
	@Id
	private int employeeId;
	private String employeeName;
	private String employeeMail;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeMail() {
		return employeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
	
}
