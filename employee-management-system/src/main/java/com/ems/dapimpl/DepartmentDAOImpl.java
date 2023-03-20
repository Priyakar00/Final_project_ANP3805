package com.ems.dapimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class DepartmentDAOImpl implements DepartmentDAO {

	//an unplimented method for save new department
	public void saveDepartment(Department dept) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(dept);
			session.getTransaction().commit();
			session.clear();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	public Department getDepartmentUsingId(int id) {
		try(Session session=HibernateUtil.getSession()){
			Department dept=session.get(Department.class, id);
			return dept;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//an unplimented method for update department
	@Override
	public Department updateDepartment(int id, Department department) {
		
		return null;
	}
	
	//an unplimented method for assign an employee to department
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session=HibernateUtil.getSession()){
			Employee emp=session.get(Employee.class, employeeId);
			Department dept=session.get(Department.class, deptId);
			
			List<Employee> employees=new ArrayList<>();
			employees.add(emp);
			
			dept.setEmployees(employees);
			emp.setDept(dept);
			
			dept.setTotalEmp(dept.getTotalEmp()+1);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//an unplimented method for assign an manager to department
	@Override
	public void assignManagerToDept(int manId, int deptId) {
		
		try(Session session=HibernateUtil.getSession()){
			Manager man=session.get(Manager.class, manId);
			Department dept=session.get(Department.class, deptId);
			
			dept.setManager(man);
			
			dept.setTotalEmp(dept.getTotalEmp()+1);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
