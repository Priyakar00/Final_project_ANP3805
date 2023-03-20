package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class EmployeeCRUD {

	//static Scanner sc=new Scanner(System.in);
	static EmployeeService empService= new EmployeeServiceImpl();
	
	
	//save employee details
	public static void saveEmployee() {
		
    	Employee emp=new Employee();
//    	sc.nextLine();
//    	System.out.println("Enter name: ");
//    	String name=sc.nextLine();
//    	System.out.println("Enter address: ");
//    	String add=sc.nextLine();
//    	System.out.println("Enter salary: ");
//    	double sal=sc.nextDouble();
//    	System.out.println("Enter contact number: ");
//    	String cont=sc.next();
//    	sc.nextLine();
//    	System.out.println("Enter email: ");
//    	String email=sc.nextLine();
//    	System.out.println("Enter designation: ");
//    	String des=sc.next();
//    	System.out.println("Enter DOJ: ");
//    	LocalDate date=LocalDate.parse(sc.next()); //yy-mm-dd
//    	System.out.println("Enter username: ");
//    	String user=sc.next();
//    	System.out.println("Enter password: ");
//    	String pass=sc.next();
//    	
		
		String name=JOptionPane.showInputDialog("Enter name "," Type here....");
		String add=JOptionPane.showInputDialog("Enter address: ","Type here....");
		Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "," Type here...."));
		String cont=JOptionPane.showInputDialog("Enter phone no "," Type here....");
		String email=JOptionPane.showInputDialog("Enter email: "," Type here....");
		String des=JOptionPane.showInputDialog("Enter description: "," Type here....");
		LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter doj: "," Type here...."));
		String user=JOptionPane.showInputDialog("Enter username: "," Type here....");
		String pass=JOptionPane.showInputDialog("Enter password: "," Type here....");
		
		
		
    	emp.setEmpName(name);
    	emp.setEmpAddress(add);
    	emp.setSalary(sal);
    	emp.setContact(cont);
    	emp.setEmail(email);
    	emp.setDesignation(des);
    	emp.setDOJ(date);
    	emp.setUserName(user);
    	emp.setPassword(pass);
    	emp.setRole("Employee");
    	
    	empService.saveEmployee(emp);
    	System.out.println("Employee details saved!!");
	}
	
	//getting employee details by id
	public static void getEmployee() throws GlobalException{
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search details:  "," Enter id here...."));
		EmployeeDTO emp1=empService.getEmployeeUsingId(id);
		
		System.out.println("Employee name: "+emp1.getEmpName());
		System.out.println("Employee address: "+emp1.getEmpAddress());
		System.out.println("Employee salary: "+emp1.getSalary());
		System.out.println("Employee Contact: "+emp1.getContact());
		System.out.println("Employee Email: "+emp1.getEmail());
		   
		}
	
	//update employee details
	public static void updateEmployee() throws GlobalException{
		Employee emp1=new Employee();
			
		String name=JOptionPane.showInputDialog("Enter name "," Type here....");
		String add=JOptionPane.showInputDialog("Enter address: ","Type here....");
		Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "," Type here...."));
		String cont=JOptionPane.showInputDialog("Enter phone no "," Type here....");
		String email=JOptionPane.showInputDialog("Enter email: "," Type here....");
		String des=JOptionPane.showInputDialog("Enter description: "," Type here....");
		LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter doj: "," Type here...."));
		String user=JOptionPane.showInputDialog("Enter username: "," Type here....");
		String pass=JOptionPane.showInputDialog("Enter password: "," Type here....");
		
		emp1.setEmpName(name);
    	emp1.setEmpAddress(add);
    	emp1.setSalary(sal);
    	emp1.setContact(cont);
    	emp1.setEmail(email);
    	emp1.setDesignation(des);
    	emp1.setDOJ(date);
    	emp1.setUserName(user);
    	emp1.setPassword(pass);
    	emp1.setRole("Employee");
		
    	empService.updateEmployee(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ", "Type here..")), emp1);
		System.out.println("Employee details update successfully!!");
    	
	}
	
	//delete employee details
	public static void deleteEmployee() {
		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type here.."));
		empService.deleteEmployeeById(id);
		
	}
	
	//getting employee details by email id
	public static void getEmployeeByEmail()
	{
		String email=JOptionPane.showInputDialog("Enter email to search..", "Type here..");
		
		EmployeeDTO emp1=empService.getEmployeeByEmail(email);
		
		System.out.println("Employee name: "+emp1.getEmpName());
		System.out.println("Employee address: "+emp1.getEmpAddress());
		System.out.println("Employee salary: "+emp1.getSalary());
		System.out.println("Employee Contact: "+emp1.getContact());
		System.out.println("Employee Email: "+emp1.getEmail());
		System.out.println("Employee Designation: "+emp1.getDesignation());
		System.out.println("Employee D.O.J: "+emp1.getDOJ());
		
		
	}
	

	public static void login() {
		
		String user=JOptionPane.showInputDialog("Enter user name: ", "Type here..");
		String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
		
		
		empService.login(user, pass);
		
	}
	
	public static void afterloginEmployee() {
		
		System.out.println();
    	
    	System.out.println("A)Save new employee\nB)To check employee details using Id\nC)To check employee details using email\nD)To"
    			+ "Update employee details\nE)To Delete an employee");
    	
    	String choice=JOptionPane.showInputDialog("Enter choice: "," Type here....");
    	
    	switch(choice) {
    	case "A":
    	    saveEmployee();
    	break;
    	case "B":
            getEmployee();
    		break;
    	case "C":
    		getEmployeeByEmail();
    		break;
    	case "D":
    		updateEmployee();
    		break;	
    	case "E": 
    		deleteEmployee();
    		break;
    	}
    	
	}
	
	
}
