package com.ems;


import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;


public class App 																					
{
	static AdminService adminService=new AdminServiceImpl();
	static EmployeeService empService=new EmployeeServiceImpl();
	static ManagerService manService=new ManagerServiceImpl();
	
	static Scanner sc=new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    
    public static void mainMenu()
    {
       int ch;
       do {
    	   System.out.println( "..................WELCOME................" );
    	   System.out.println();
    	   System.out.println("1)Admin\n2)Employee\n3)Manager\n4)Exit");
    	   System.out.println();
    	    
    	   ch=Integer.parseInt(JOptionPane.showInputDialog("Enter choice: "," Type here...."));
    	   switch(ch) 
    	   {
    	   case 1:
    		   mainAdmin();
    		   break;
    	   case 2:
    	       mainUser();
    	   case 3:
    		   mainManager();
    		   break;     
    	   case 4:
    		   System.exit(0);
    		   break;
    		 default :
    			 System.out.println("Wrong Input!!");
    	   }
    	   
       }while(ch!=4);
    }
    
    //main menu for employee
    public static void mainUser() {
    	System.out.println();
    	System.out.println(".........................................");
    	System.out.println("Welcome to employee portal");
    	System.out.println();
    	do{
    		System.out.println("A)Login\nB)Exit");
    	
    	String ch=JOptionPane.showInputDialog("Enter choice: ", "Type here..");
    	
    	switch(ch)
    	{ 	
    	case "A":
    		boolean status=empService.login(JOptionPane.showInputDialog("Enter user name:", "Type here"),
    		JOptionPane.showInputDialog("Enter password:","Type here.."));
    		
    		if(status==true)
    		{
    		 EmployeeCRUD.afterloginEmployee();
    		}
    		else 
    		{
    		  JOptionPane.showMessageDialog(null, "Wrong credentials");
    		}
    		break;
    	case "B":
    		mainMenu();
    		break;	
    	}
    	
      }while(true);	
    }
    
    
    
    //main menu for admin
    public static void mainAdmin() {
    	System.out.println();
    	System.out.println("......................................");
    	System.out.println("Welcome to admin portal");
    	System.out.println();
    	do{
    		System.out.println("A)Login\nB)Exit");
    	
    	
    	String choice=JOptionPane.showInputDialog("Enter choice: ", "Type here..");
    	
    	switch(choice)
    	{ 	
    	case "A":
    		boolean status=adminService.login(JOptionPane.showInputDialog("Enter user name:", "Type here"),
    		JOptionPane.showInputDialog("Enter password:","Type here.."));
    		
    		if(status==true)
    		{
    		  AdminCRUD.afterLoginAdmin();
    		}
    		else 
    		{
    		  JOptionPane.showMessageDialog(null, "Wrong credentials");
    		}
    		break;
    	case "B":
    		mainMenu();
    		break;	
    	}
    	
      }while(true);	
    }
    
    
    
   //main menu for manager
    public static void mainManager() {
    	System.out.println();
    	System.out.println(".....................................");
    	System.out.println("Welcome to manager portal");
    	System.out.println();
    	do{
    		System.out.println("A)Login\nB)Exit");
    	
    	String ch=JOptionPane.showInputDialog("Enter choice: ", "Type here..");
    	
    	switch(ch)
    	{ 	
    	case "A":
    		boolean status=manService.login(JOptionPane.showInputDialog("Enter user name:", "Type here"),
    		JOptionPane.showInputDialog("Enter password:","Type here.."));
    		
    		if(status==true)
    		{
    		  ManagerCRUD.afterloginManager();
    		}
    		else 
    		{
    		  JOptionPane.showMessageDialog(null, "Wrong credentials");
    		}
    		break;
    	case "B":
    		mainMenu();
    		break;	
    	}
    	
      }while(true);	
    	
    }
    
    
}
