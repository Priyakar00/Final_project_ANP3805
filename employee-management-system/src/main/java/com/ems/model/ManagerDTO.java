package com.ems.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ManagerDTO {

	private String manName;
	private String manEmail;
	private String manAdd;
	private double mansalary;
	
	private DepartmentDTO dept;
	
}
