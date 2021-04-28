package com.mph.controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.mph.model.Employee;
import com.mph.model.Manager;
import com.mph.model.Salary;
import com.mph.dao.EmployeeDao;

interface MyConsumer
{
	public void accept(List elist);
}

public class EmployeeController implements EmployeeInterface {

	Employee emp;
	Salary sal;
	Manager man;
	List<Employee> emplist=new ArrayList<Employee>();
	List <Employee>emlist=new ArrayList<Employee>();
	List <Employee>emplist1=new ArrayList<Employee>();
	EmployeeDao empdao=new EmployeeDao();
	public List<Employee> addEmployee(){
		
		 emp = new Employee();

		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("enter the id");
			int eno = sc.nextInt();
			emp.setEid(eno);
			System.out.println("enter the name");
			String ename = sc.next();
			emp.setEname(ename);
			
			
			
			sal= new Salary();
			System.out.println("enter basic salary");
			int basic=sc.nextInt();
			sal.setBasic(basic);
			
			
			sal.setDa(sal.getBasic());
			
			sal.setHra(sal.getBasic());
			System.out.println("enter PF");
			int pf=sc.nextInt();
			sal.setPf(pf);
			
			sal.setGross(basic,sal.getDa(),sal.getHra());
			sal.setNet(sal.getGross(), pf);
			emp.setSalary(sal);
			
			//emplist.add(emp);
			empdao.insert_emp(emp);
			System.out.println("Employee"+" " + eno +" "+"successfull");
			
			return emplist;
			
	}
		
	public void viewEmployee(List elist) {
		
		//elist.forEach((lis)->System.out.println(lis));
		empdao.view_emp();
	}
	
	public List<Employee> addManager() {
		
		man=new Manager();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter manager department");
		String dept=sc.next();
		man.setDept(dept);
		
		System.out.println("enter the id");
		int eno = sc.nextInt();
		man.setEid(eno);
		System.out.println("enter the name");
		String ename = sc.next();
		man.setEname(ename);
		
		
		sal= new Salary();
		System.out.println("enter basic salary");
		int basic=sc.nextInt();
		sal.setBasic(basic);
		System.out.println("enter DA");
		int da=sc.nextInt();
		sal.setDa(da);
		System.out.println("enter HRA");
		int hra=sc.nextInt();
		sal.setHra(hra);
		System.out.println("enter PF");
		int pf=sc.nextInt();
		sal.setPf(pf);
		
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		man.setSalary(sal);
		
		
		emlist.add(man);
		
		System.out.println("Manager" + " "+ eno + " "+ "succesfull");
		return emlist;
		
	}
	
	public void viewManager(List elist) {
		
		elist.forEach((ls)->System.out.println(ls));
		
	}
	
	
	@Override
	public void sortEmployee(List elist) {
		
		Collections.sort(emplist, Employee.nameComparator);
		Iterator i=elist.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
	}
	public void sortusingstearm(List elist)
	{
		
		Predicate<Employee> p2=emp2->emp2.getEname().startsWith("a")||emp2.getEname().startsWith("A");
		emplist.stream().filter(p2).forEach(System.out::println);
	}
	
public void dataserial() {
		
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
			try {
				fos=new FileOutputStream("myfile.txt");
				oos= new ObjectOutputStream(fos);
				oos.writeObject(emp);
				
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
			System.out.println("Data serialized");
		
	}
	
	public List<Employee> adataDeserial()
	{
		Employee em=null;
		try (FileInputStream fis = new FileInputStream("myfile.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) 
		{
			em=(Employee)ois.readObject();
			emplist1.add(em);
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		/*System.out.println(em.getEid());
		System.out.println(em.getEname());
		System.out.println(em.getSalary());*/
		return emplist1;
	}
		

		public void dataDeserial(List elist) {
			
			elist.forEach((l)->System.out.println(l));
		}


		public void insertusingProc()
		{
			Employee  e= new Employee();
			 Scanner sc = new Scanner(System.in);
				
			 	System.out.println("enter the id");
				int eno = sc.nextInt();
				e.setEid(eno);
				System.out.println("enter the name");
				String ename = sc.next();
				e.setEname(ename);
			empdao.insertRecord(e);
		}
		
	public void meta_data()
	{
		empdao.rsmd();
	}

	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}

	@Override
	public void type_scroll_sensitive_rs() {
		empdao.type_scroll_sensitive_rs();
		
	}

	@Override
	public void batch_update() {
		empdao.batch_update();		
	}
	

	

	

}
