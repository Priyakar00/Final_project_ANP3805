package com.ems.dao;

import com.ems.entity.Department;

public interface DepartmentDAO {
 
	void saveDepartment(Department dept);
	Department getDepartmentUsingId(int id);
	Department updateDepartment(int id, Department department);
	void assignEmployeeToDept(int employeeId, int deptId);
	void assignManagerToDept(int manId, int deptId);
}
