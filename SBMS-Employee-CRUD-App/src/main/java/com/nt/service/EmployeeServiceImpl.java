package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeServiceMgmt {

	private EmployeeRepository repo;
	
	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "Employee Added";
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee e = repo.findById(id)
					.orElseThrow(()-> new IllegalAccessError("Employee not exist for this id "+id));
		return e;
	}

	@Override
	public Employee updateEmployee(Integer id, Employee emp) {
		Employee e = repo.findById(id)
				.orElseThrow(()-> new IllegalAccessError("Employee not exist for this id "+id));
		e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		Employee emp1 = repo.save(e);
		return emp1;
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Integer id) {
		Employee e = repo.findById(id)
				.orElseThrow(()-> new IllegalAccessError("Employee not exist for this id "+id));
		repo.delete(e);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Employee Deleted", Boolean.TRUE);
		return response;
	}

}
