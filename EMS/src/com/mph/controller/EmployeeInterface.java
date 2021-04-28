package com.mph.controller;

import java.util.List;

import com.mph.model.Employee;

public interface EmployeeInterface {
	public List addEmployee();
	public void viewEmployee(List elist);
	public List addManager();
	public void viewManager(List elist);
	public void sortEmployee(List elist);
	public void sortusingstearm(List elist);
	public void dataserial();
	public void dataDeserial(List elist);
	public void insertusingProc();
	public void meta_data();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs();
	public void batch_update();
}
