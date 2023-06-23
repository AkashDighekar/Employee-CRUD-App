package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.Employee;

public interface IEmployeeServiceMgmt {
	public String addEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Integer id);
	public Employee updateEmployee(Integer id, Employee emp);
	public Map<String, Boolean> deleteEmployee(Integer id);
}
