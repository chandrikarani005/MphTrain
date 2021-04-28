package com.mph.model;

public class Manager extends Employee {
	
private String dept;

public Manager() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEid() {
	return super.getEid();
}
public String getEname() {
	return super.getEname();
}
public Salary getSalary() {
	return super.getSalary();
}

public Manager(String dept) {
	super();
	this.dept = dept;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}
@Override
public String toString() {
	return "Manager [dept=" + dept + "]" + super.toString() ;
}








}
