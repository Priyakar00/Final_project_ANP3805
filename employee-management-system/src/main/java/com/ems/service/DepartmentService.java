package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {

	void saveDepartment(Department dept);
	DepartmentDTO getDepartmentUsingId(int id);
	
	DepartmentDTO updateDepartment(int id, Department department);
	void assignEmployeeToDept(int employeeId, int deptId);
	void assignManagerToDept(int manId, int deptId);
}
