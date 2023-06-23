package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeServiceMgmt;

@RestController
public class EmployeeRestController {
		@Autowired
		private IEmployeeServiceMgmt service;
		
		@PostMapping("/employee")
		public ResponseEntity<String> saveEmployeeData(@RequestBody Employee e){
			String msg = service.addEmployee(e);
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		@GetMapping("/employee")
		public ResponseEntity<List<Employee>> fetchAllEmployeeData(){
			List<Employee> list = service.getAllEmployee();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> fetchEmployeeById(@PathVariable Integer id){
			Employee byId = service.getEmployeeById(id);
			return new ResponseEntity<>(byId, HttpStatus.OK);
		}
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> modifyEmployee(@PathVariable Integer id, @RequestBody Employee emp){
			Employee updateEmp = service.updateEmployee(id, emp);
			return new ResponseEntity<>(updateEmp, HttpStatus.OK);
		}
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<Map<String, Boolean>> removeEmployeeData(@PathVariable Integer id){
			Map<String, Boolean> response = service.deleteEmployee(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
}
