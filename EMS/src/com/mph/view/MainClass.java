package com.mph.view;

import java.util.List;

import java.util.Scanner;
import java.util.function.BiPredicate;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.model.Employee;
import com.mph.usernameexception.UserNameNotFoundException;
import java.util.Arrays;
public class MainClass {

	public static void main(String[] args) throws UserNameNotFoundException {
		
		EmployeeInterface ec =new EmployeeController();
		List elist=null;
		Scanner sc = new Scanner(System.in);
		String input =null;
		System.out.println("enter username");
		String un =sc.next();
		System.out.println("enter password");
		String pwd =sc.next();
		try {
BiPredicate<String,String> bp =(unn,pws)->unn.equals("chandu")&& pws.equals("chandu");
{ 
if (bp.test(un, pwd))
	{
		
		System.out.println("Loading Please Wait....");
		try
		{
			Thread.sleep(2000);
			
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		
	
		do {
			System.out.println("enter your choice");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Add manager");
			System.out.println("4.View manager");
			System.out.println("5.Sort Employee");
			System.out.println("6.Sort Employee with stream");
			System.out.println("7.Data serial");
			System.out.println("8.Data Deserial");
			System.out.println("9.plsql Procedure insert");
			System.out.println("10.Get Meta Data Information");
			System.out.println("11.Type forward only rs");
			System.out.println("12.Type insensitive rs");
			System.out.println("13.Type sensitive rs");
			System.out.println("14.Batch Update");
			int choice =sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			elist=ec.addEmployee();
			break;
		}
		
		case 2:
		{
			ec.viewEmployee(elist);
			break;
		}
		case 3:
		{
			elist=ec.addManager();
			break;
		}
		case 4:
		{
			ec.viewManager(elist);
			break;
		}
		case 5:
		{
			ec.sortEmployee(elist);
			break;
		}
		case 6:
		{
			ec.sortusingstearm(elist);
			break;
		}
		case 7:
		{
			ec.dataserial();
			break;
		}
		case 8:
		{
			ec.dataDeserial(elist);
			break;
		}
		case 9:
		{
			ec.insertusingProc();
			break;
		}
		case 10:
		{
			ec.meta_data();
			break;
		}
		case 11:
		{
			ec.type_forward_only_rs();
			break;
		}
		case 12:
		{
			ec.type_scroll_insensitive_rs();
			break;
		}
		case 13:
		{
			ec.type_scroll_sensitive_rs();
			break;
			
		}
		case 14:
		{
			ec.batch_update();
			break;
		}
		default :
		{
			
		}
		}
		System.out.println("do you want to continue ? Y or y for yes");
		input =sc.next();
	
		}while(input.equals("Y")||input.equals("y"));
		System.out.println("System ended...Thank you for using our system!!!!");
		System.exit(0);
		
		}
		
	else {
		throw new UserNameNotFoundException();
		}
}
		}

		catch(UserNameNotFoundException unfe)
		{
			System.out.println(unfe);
		}

	}
}
	
	
