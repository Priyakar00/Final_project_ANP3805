package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.AdminDAO;
import com.ems.dapimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.AdminService;

//this class implemented service interface
public class AdminServiceImpl implements AdminService {
	
	AdminDAO adminDao=new AdminDAOImpl();

	
	//an unplimented method for save new admin
	@Override
	public void saveAdmin(Admin admin) {
		
		adminDao.saveAdmin(admin);
		
	}

	//an unplimented method for login as new admin
	@Override
	public boolean login(String userName, String password) {
		
		return adminDao.login(userName, password);
	}

	
	//an unplimented method for getting admin by id 
	@Override
	public AdminDTO getAdminUsingId(int id) {
		Admin admin= adminDao.getAdminUsingId(id);
		if(admin!=null)
			
		{
		  return new ModelMapper().map(admin,AdminDTO.class);
		}
		else 
			throw new GlobalException("Admin details not found!!");
	}

	
	//an unplimented method for update any admin
	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin admin1= adminDao.updateAdmin(id, admin);
		if(admin1!=null)
		{
			return new ModelMapper().map(admin1,AdminDTO.class);
		}
		else
		{
			throw new GlobalException("Admin with "+id+"not found!!");
		}
		
	}

	
	//an unplimented method for delete new admin
	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteAdminById(id);
		
	}

}
