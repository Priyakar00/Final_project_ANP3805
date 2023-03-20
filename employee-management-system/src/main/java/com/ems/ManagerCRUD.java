package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD {

	    static Scanner sc=new Scanner(System.in);
		static ManagerService manService= new ManagerServiceImpl();
		
		//save manager details
		public static void saveManager() {
			
			Manager manager=new Manager();
			
			String name=JOptionPane.showInputDialog("Enter name "," Type here....");
			String email=JOptionPane.showInputDialog("Enter email: ","Type here....");
			String add=JOptionPane.showInputDialog("Enter address: "," Type here....");
			Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "," Type here...."));
			String user=JOptionPane.showInputDialog("Enter username: ", "Type here..");
			String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
			
			
			manager.setManName(name);;
			manager.setManEmail(email);
			manager.setManAdd(add);
			manager.setMansalary(sal);
			manager.setUserName(user);
			manager.setPassword(pass);
			manager.setRole("Manager");
	
			manService.saveManager(manager);
			System.out.println("Manager details saved.");		
		}
		
		//getting manager details by id
		public static void getManager() throws GlobalException{
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search details:  "," Enter id here...."));
			ManagerDTO man=manService.getManagerUsingId(id);
			
			System.out.println("Manager name: "+man.getManName());
			System.out.println("Manager Email: "+man.getManEmail());
			System.out.println("Manager address: "+man.getManAdd());
			System.out.println("Manager salary: "+man.getMansalary());	
			   
			}
	
	
		//update manager details
		public static void updateManager() throws GlobalException{
			Manager man=new Manager();
				
			String name=JOptionPane.showInputDialog("Enter name "," Type here....");
			String email=JOptionPane.showInputDialog("Enter email: "," Type here....");
			String add=JOptionPane.showInputDialog("Enter address: ","Type here....");
			Double sal=Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "," Type here...."));
			
			String user=JOptionPane.showInputDialog("Enter username: "," Type here....");
			String pass=JOptionPane.showInputDialog("Enter password: "," Type here....");
			
			man.setManName(name);
			man.setManEmail(email);
			man.setManAdd(add);
			man.setMansalary(sal);
			man.setUserName(user);
			man.setPassword(pass);
			man.setRole("Manager");
			
	    	manService.updateManager(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ", "Type here..")), man);
			System.out.println("Manager details update successfully!!");
	    	
		}
		
		//delete manager details
		public static void deleteManager() {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type here.."));
			manService.deleteManagerById(id);
			
		}
		
		//assigning employee to manager
		public static void assignEmpToMan() {
			int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter employee id: ", "Type here.."));
			int manId=Integer.parseInt(JOptionPane.showInputDialog("Enter manager id: ", "Type here.."));
			manService.assignEmployeeToManager(empId, manId);
			JOptionPane.showMessageDialog(null, "Assigned successfully!!");
		}
		
		//for login as manager
		public static void login() {
			
			String user=JOptionPane.showInputDialog("Enter user name: ", "Type here..");
			String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
			
			manService.login(user, pass);
			
		}
		
		//login after main menu
		public static void afterloginManager() {
			
			System.out.println();
		    System.out.println("A)Save new Manager\nB)To check Manager details using Id\nC)To"
		    			+ "Update manager details\nD)To Delete manager details\nE)Assign employee to manager");
		    	
		   String choice=JOptionPane.showInputDialog("Enter choice: "," Type here....");
		        
		   switch(choice)
		   {
		    	case "A":
		    		saveManager();
		    		break;
		    	case "B":
		    		getManager();
		    		break;
		    	case "C":
		    		updateManager();
		    		break;
		    	case "D":
		    		deleteManager();
		    		break;
		    	case "E":
		             assignEmpToMan();
		    		break;
		     }
		}
		
}
