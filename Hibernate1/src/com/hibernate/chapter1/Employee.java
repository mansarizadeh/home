package com.hibernate.chapter1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	private int empId;
	private String empName;
	
	@Id
	public int getEmpID() {
		return empId;
	}
	public void setEmpID(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
