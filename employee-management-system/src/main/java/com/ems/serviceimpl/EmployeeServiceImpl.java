package com.ems.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.EmployeeDAO;
import com.ems.dapimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	//logger used to keep track of records
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	//accessing the Data Access Layer(DAO) to call the methods
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			
			@Override
			public void saveEmployee(Employee employee) {
				logger.info("New employee details added!!");
				employeeDAO.saveEmployeeDAO(employee);
			}
			
			
			//method to get details using employee id
			@Override
			public EmployeeDTO getEmployeeUsingId(int id)
			{
			Employee employee= employeeDAO.getEmployeeUsingId(id);
			if(employee!=null)
				
			{
			   logger.info("Employee with id "+id+" was retreived at"+new Date());	
			   return new ModelMapper().map(employee,EmployeeDTO.class);
			}
			else 
				//logger.error("Employee details not found!!");
				throw new GlobalException("Employee details not found!!");
			
			}
			
			// method for update new employee`
			@Override
			public EmployeeDTO updateEmployee(int id, Employee employee) {
				Employee emp= employeeDAO.updateEmployee(id, employee);
				if(emp!=null)
				{
					return new ModelMapper().map(emp, EmployeeDTO.class);
				}
				else
				{
					throw new GlobalException("Employee with "+id+"not found!!");
				}
				
				
			}
			
			//method to delete employee
			@Override
			public void deleteEmployeeById(int id) {
				employeeDAO.deleteEmployeeById(id);
				
			}
			
			//getting employee details by email
			@Override
			public EmployeeDTO getEmployeeByEmail(String email) {
				
				Employee emp=employeeDAO.getEmployeeByEmail(email);
				if(emp!=null) {
					return new ModelMapper().map(emp, EmployeeDTO.class);
				}
				else {
					throw new GlobalException("Employee with "+email+"not found!!");
				}
				
			}


			//method to login  as employee
			@Override
			public boolean login(String userName, String password) {
			
				 return employeeDAO.login(userName, password);
			}
	
	
}
