package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;
import com.ems.serviceimpl.DepartmentServiveImpl;

public class DepartmentCRUD {
	
	static DepartmentService deptService=new DepartmentServiveImpl();
	
	public static void addDepartment()
	{
		Department dept=new Department();
		
		String deptName= JOptionPane.showInputDialog("Enter dept. name: ", "Type here..");
		int total=Integer.parseInt(JOptionPane.showInputDialog("Enter total employee: ", "Type here..."));
		String loc=JOptionPane.showInputDialog("Enter location: ", "Type here..");
		
		dept.setDeptName(deptName);
		dept.setTotalEmp(total);
		dept.setLocation(loc);
		
		deptService.saveDepartment(dept);
		System.out.println("New department details added!!");
		
	}
	
	public static void getDepartment() throws GlobalException{
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to search: ", "Type here.."));
		
		DepartmentDTO dept1=deptService.getDepartmentUsingId(id);
		
		System.out.println("Department Name: "+dept1.getDeptName());
		System.out.println("Department Location: "+dept1.getLocation());
		System.out.println("Total employee: "+dept1.getTotalEmp());
		System.out.println("================================");
		
	}
	
	public static void updateDepartment() throws GlobalException
	{
		Department dept2=new Department();
		String deptName=JOptionPane.showInputDialog("Enter department name: ","Type here..");
		int totalEmp=Integer.parseInt(JOptionPane.showInputDialog("Enter Id to update: "," Type here.."));
		String location=JOptionPane.showInputDialog("Enter location: ", "Type here..");
		
		dept2.setDeptName(deptName);
		dept2.setTotalEmp(totalEmp);
		dept2.setLocation(location);
		
		deptService.updateDepartment(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update..", "Type here..")), dept2);
		
		System.out.println("Department details updated");
	}
	
	public static void assign() throws GlobalException {
		
		int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter dept. Id: ", "Type here.."));
		int empId=Integer.parseInt(JOptionPane.showInputDialog("Enter employee Id: ", "Type here.."));
		
		deptService.assignEmployeeToDept(empId, deptId);
		JOptionPane.showMessageDialog(null, "Employee has been assigned successfully!!");
		
	}
	
	public static void assignManToDept()throws GlobalException{
		int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter dept. Id: ", "Type here.."));
		int manId=Integer.parseInt(JOptionPane.showInputDialog("Enter manager Id: ", "Type here.."));
		
		deptService.assignManagerToDept(manId, deptId);
		JOptionPane.showMessageDialog(null, "Manager has been assigned successfully!!");
		
		
	}
	
	
	
	

}
