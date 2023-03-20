package com.ems;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

public class AdminCRUD {

	static AdminService adminService=new AdminServiceImpl();
	
	//for save new admin
	public static void saveAdmin() {
		
		Admin admin=new Admin();
		String name=JOptionPane.showInputDialog("Enter admin name: "," Type here..");
		String email=JOptionPane.showInputDialog("Enter email: ", "Type here...");
		String user=JOptionPane.showInputDialog("Enter user name: ", "Type here...");
		String pass=JOptionPane.showInputDialog("Enter password: ", "Type here...");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added!!");
		
	}
	
	//for login as admin
	public static void login() {
		
		String user=JOptionPane.showInputDialog("Enter user name: ", "Type here..");
		String pass=JOptionPane.showInputDialog("Enter password: ", "Type here..");
		adminService.login(user, pass);
	}
	
	//getting admin details by id
		public static void getAdmin() throws GlobalException{
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search details:  "," Enter id here...."));
			AdminDTO admin1=adminService.getAdminUsingId(id);
			
			System.out.println("Admin name: "+admin1.getAdminName());
			System.out.println("Admin Email: "+admin1.getAdminEmail());
			   
			}
		//update admin details
		public static void updateAdmin() throws GlobalException{
			Admin ad=new Admin();
				
			String name=JOptionPane.showInputDialog("Enter name "," Type here....");
			String email=JOptionPane.showInputDialog("Enter email: "," Type here....");
			String user=JOptionPane.showInputDialog("Enter username: "," Type here....");
			String pass=JOptionPane.showInputDialog("Enter password: "," Type here....");
			
			ad.setAdminName(name);
			ad.setAdminEmail(email);
			ad.setUserName(user);
			ad.setPassword(pass);
			ad.setRole("Admin");
			
	    	adminService.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update: ", "Type here..")), ad);
			System.out.println("Admin details update successfully!!");
	    	
		}
		
		
		//delete Admin details
		public static void deleteAdmin() {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type here.."));
			adminService.deleteAdminById(id);
			
		}
		
	//after login method to check all menu
	public static void afterLoginAdmin() {
		System.out.println();
		System.out.println("1)Save new admin\n2)To check admin using id\n3)To update admin details\n4)To delete an admin");
		System.out.println();
		System.out.println("5)Save new employee\n6)To check employee details using Id\n"
				+ "7)To check employee details using email\n8)To Update employee details\n9)To Delete an employee");
		System.out.println();
		System.out.println("10)Save new Department\n11)To check Department details using Id\n"
				+ "12)Assign employee to department\13)Assign manager to department");
		System.out.println();
		System.out.println("14)Save new Manager\n15)To check Manager details using Id\n16)To"
		    			+ "Update manager details\n17)To Delete manager details\n18)Assign employee to manager");
		
		String choice=JOptionPane.showInputDialog("Enter choice: ", "Type here..");
		switch(choice) {
		case "1":
			saveAdmin();
			break;
		case "2":
			getAdmin();
			break;
		case "3":
			updateAdmin();
			break;
		case "4":
			deleteAdmin();
			break;	
		case "5":
			EmployeeCRUD.saveEmployee();
			break;
		case "6":
			EmployeeCRUD.getEmployee();
			break;
		case "7":
			EmployeeCRUD.getEmployeeByEmail();
			break;
		case "8":
			EmployeeCRUD.updateEmployee();
			break;
		case "9":
			EmployeeCRUD.deleteEmployee();
			break;
		case "10":
			DepartmentCRUD.addDepartment();
			break;
			
		case "11":
			DepartmentCRUD.getDepartment();
			break;
			
		case "12":
			DepartmentCRUD.assign();
			break;
			
		case "13":
			DepartmentCRUD.assignManToDept();
			break;
			
		case "14":
			ManagerCRUD.saveManager();
            break;
		case "15":
			ManagerCRUD.getManager();
			break;
		case "16":
			ManagerCRUD.updateManager();
			break;
		case "17":
			ManagerCRUD.deleteManager();
			break;
		case "18":
			ManagerCRUD.assignEmpToMan();
			break;
		
		}
		
	}
	
	
}
