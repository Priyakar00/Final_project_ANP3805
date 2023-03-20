package com.ems.serviceimpl;


import org.modelmapper.ModelMapper;

import com.ems.dao.ManagerDAO;
import com.ems.dapimpl.ManagerDAOImpl;
import com.ems.entity.Employee;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	
	//accessing the Data Access Layer(DAO) to call the methods
	ManagerDAO managerDAO = new ManagerDAOImpl();
	
    //unimplimented method
	@Override
	public void saveManager(Manager manager) {
		managerDAO.saveManager(manager);
	}
	
	//unimplimented method
	@Override
	public ManagerDTO getManagerUsingId(int id) {
		Manager manager= managerDAO.getManagerUsingId(id);
		if(manager!=null)
			
		{
		   		return new ModelMapper().map(manager,ManagerDTO.class);
		}
		else 
			throw new GlobalException("Manager details not found!!");
		
		
	}

	//unimplimented method
	@Override
	public ManagerDTO updateManager(int id, Manager manager) {
		
		Manager man= managerDAO.updateManager(id, manager);
		if(man!=null)
		{
			return new ModelMapper().map(man, ManagerDTO.class);
		}
		else
		{
			throw new GlobalException("Manager with "+id+"not found!!");
		}
		
	}
	
	//unimplimented method
	@Override
	public void deleteManagerById(int id) {
		managerDAO.deleteManagerById(id);
		
	}

	@Override
	public void assignEmployeeToManager(int empId, int manId) {
		
		managerDAO.assignEmployeeToManager(empId, manId);
	}

	@Override
	public boolean login(String userName, String password) {
		 return managerDAO.login(userName, password);
	}

}
