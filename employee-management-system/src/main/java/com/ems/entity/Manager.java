package com.ems.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Manager extends User{

	@Column(length=30, nullable=false)
	private String manName;
	
	@Column(length=30, nullable=false)
	private String manEmail;
	
	@Column(length=50, nullable=false)
	private String manAdd;
	
	@Column(length=20, nullable=false)
	private double mansalary;
	
	@OneToMany
	private List<Employee> employees;
	
	
	
	
}
