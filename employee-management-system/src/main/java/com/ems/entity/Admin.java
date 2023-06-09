package com.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin extends User {

	@Column(name="admin_name", length=20, nullable=false)
	private String adminName;
	
	@Column(name="amdin_email",length=50, nullable=false)
	private String adminEmail;
	
	
}
