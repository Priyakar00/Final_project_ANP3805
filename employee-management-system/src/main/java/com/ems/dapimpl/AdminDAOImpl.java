package com.ems.dapimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.AdminDAO;
import com.ems.entity.Admin;
import com.ems.entity.Employee;

//this class implemented dao layer interface
public class AdminDAOImpl implements AdminDAO {

	//an unplimented method for save new admin
	@Override
	public void saveAdmin(Admin admin) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			session.clear();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//an unplimented method for login as admin
	public boolean login(String userName, String password) {
		
	    try(Session session=HibernateUtil.getSession())
	    {
	    	int id=Integer.parseInt(JOptionPane.showInputDialog("Enter admin Id: ", "Type here.."));
	    	Admin admin=session.get(Admin.class, id);
	    	if(admin.getUserName().equals(userName) && admin.getPassword().equals(password) && admin.getRole().equals("admin")) 
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
	

	//an unplimented method for getting admin by id
	@Override
	public Admin getAdminUsingId(int id) {
		try(Session session=HibernateUtil.getSession()){
			Admin admin=session.get(Admin.class, id);
			return admin;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	

	//an unplimented method for update admin
	@Override
	public Admin updateAdmin(int id, Admin admin) {
		try(Session session=HibernateUtil.getSession()){
			Admin ad=session.get(Admin.class, id);
			
			//updating existing details with the new one
			
			ad.setAdminName(ad.getAdminName());
			ad.setAdminEmail(ad.getAdminEmail());
			
			ad.setUserName(ad.getUserName());
			ad.setPassword(ad.getPassword());
			
			
			session.beginTransaction();
			session.saveOrUpdate(ad);
			session.getTransaction().commit();
			
			return ad;//returning admin entity
			
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

	//an unplimented method for delete admin by id
	@Override
	public void deleteAdminById(int id) {
		
        try(Session session=HibernateUtil.getSession()){
			
	     Admin admin=session.load(Admin.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Are you "
					+ "sure?", JOptionPane.YES_NO_OPTION); //showing yes no option calling from joptionpane
			
			if(input==0)
			{
				session.delete(admin);

				JOptionPane.showMessageDialog(null, "Object is deleted!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "User wants to retain it!");
			   
			}
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
	}

	

}
