package com.ems.dapimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public void saveManager(Manager manager) {
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			//add all the new employee details
			session.save(manager);
			
			//java object saved to the database
			session.getTransaction().commit();
			
			//clear the session
			session.clear();
			
		}
		catch(HibernateException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	
	
	@Override
	public Manager getManagerUsingId(int id) {
		
		try(Session session=HibernateUtil.getSession()){
			Manager manager=session.get(Manager.class, id);
			return manager;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
	//updating existing details with the new one
	@Override
	public Manager updateManager(int id, Manager manager) {
		
		
		try(Session session=HibernateUtil.getSession()){
			Manager man=session.get(Manager.class, id);	
			
			man.setManEmail(manager.getManName());
			man.setManEmail(manager.getManEmail());;
			man.setManAdd(manager.getManAdd());;
			
			man.setUserName(manager.getUserName());;
			man.setPassword(manager.getPassword());;
			
			session.beginTransaction();
			session.saveOrUpdate(man);
			session.getTransaction().commit();
			
			return man;//returning manager entity
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	
	
    
	@Override
	public void deleteManagerById(int id) {
		
try(Session session=HibernateUtil.getSession()){
			
			Manager manager=session.load(Manager.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Are you "
					+ "sure?", JOptionPane.YES_NO_OPTION);
			
			if(input==0) {
				session.delete(manager);

				JOptionPane.showMessageDialog(null, "Object is deleted!!");
			}
			else {
				JOptionPane.showMessageDialog(null, "User wants to retain it!");
			   
			}
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}

		
	}



	@Override
	public void assignEmployeeToManager(int empId, int manId) {

		try(Session session=HibernateUtil.getSession()){
			Employee emp = session.get(Employee.class, empId);
			Manager man = session.get(Manager.class, manId);
			
			List<Employee> emps =new ArrayList<>();
			emps.add(emp);
			
			man.setEmployees(emps);;
			emp.setManager(man);;
			
			session.beginTransaction();
			session.saveOrUpdate(man);
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}



	@Override
	public boolean login(String userName, String password) {

		 try(Session session=HibernateUtil.getSession())
		    {
		    	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter manager Id: ", "Type here.."));
		    	Manager man=session.get(Manager.class, id);
		    	if(man.getUserName().equals(userName) && man.getPassword().equals(password) && man.getRole().equals("Manager")) 
		    	{
		    		JOptionPane.showMessageDialog(null, "Successfully logged in!!");
		    		return true;
		    	}
		    	else 
		    	{
		    		JOptionPane.showMessageDialog(null, "Wrong credentials!!");
		    		return false;
		    	}
		    
		    }
		
	}



	

}
