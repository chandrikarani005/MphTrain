package com.mph.model;

import java.io.Serializable;
import java.util.Comparator;



//pojo class----Plain OLd Java Object
public class Employee implements Serializable {

	private int eid;
	private String ename;
	private Salary salary;

	public Employee() {
		System.out.println("from Emp constructor....");
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEid() {
		return eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}

	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}

	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee s1, Employee s2) {
			
			return (s1.getEname().compareTo(s2.getEname()));
		}
		
		
	};

	
}
