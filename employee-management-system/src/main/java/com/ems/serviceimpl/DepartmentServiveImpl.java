package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.DepartmentDAO;
import com.ems.dapimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;

public class DepartmentServiveImpl implements DepartmentService {
	
	//accessing the data access layer(DAO) to call the methods
	DepartmentDAO deptDAO=new DepartmentDAOImpl();
	

	@Override
	public void saveDepartment(Department dept) {
		deptDAO.saveDepartment(dept);
	}

	@Override
	public DepartmentDTO getDepartmentUsingId(int id) {
		Department department=deptDAO.getDepartmentUsingId(id);
		if(department!=null) {
			return new ModelMapper().map(department, DepartmentDTO.class);
		}
		else {
			throw new GlobalException("Department details not found!");
		}
	}

	
	
	@Override
	public DepartmentDTO updateDepartment(int id, Department department) {
		Department dept=deptDAO.updateDepartment(id, department);
		if(dept!=null) {
			return new ModelMapper().map(dept, DepartmentDTO.class);
			
		}
		else {
			throw new GlobalException("Department with "+id+" not found!!");
		}
		
	}
	
	
	
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		deptDAO.assignEmployeeToDept(employeeId, deptId);
		
	}

	@Override
	public void assignManagerToDept(int manId, int deptId) {
		deptDAO.assignManagerToDept(manId, deptId);
	}
	
	

}
