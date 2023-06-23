package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_INFO")
public class Employee {
		@Id
		@Column(name = "EMP_ID")
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Integer id;
		
		@Column(name = "EMP_NAME")
		private String name;
		
		@Column(name = "EMP_EMAIL")
		private String email;
}
