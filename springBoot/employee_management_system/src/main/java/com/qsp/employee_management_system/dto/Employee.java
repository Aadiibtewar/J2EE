package com.qsp.employee_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee_Info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empId")
	private int id;
	@Column(name = "empName")
	private String name;
	@Column(name = "empPhone", unique = true)
	private long phone;
	@Column(name = "empAddress")
	private String address;
	@Column(name = "empEmail", unique = true)
	private String email;
	@Column(name = "empPassword")
	private String password;
	@Column(name = "empSalary")
	private double salary;
	@Column(name = "empdesignation")
	private String designation;
	@Column(name = "employeeGrade")
	private char grade;
}
