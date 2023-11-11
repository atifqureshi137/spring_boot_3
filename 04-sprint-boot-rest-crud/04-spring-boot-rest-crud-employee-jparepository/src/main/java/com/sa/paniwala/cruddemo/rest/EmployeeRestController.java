package com.sa.paniwala.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.paniwala.cruddemo.entity.Employee;
import com.sa.paniwala.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmpoloyeeService) {
		this.employeeService = theEmpoloyeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> listOfEmployees() {
		return employeeService.listEmployees();
	}
	
	
	@GetMapping("/employees/{employeeId}")
	public Employee findEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (null == employee) {
			throw new RuntimeException("Employee Id not found");
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);
		return savedEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.save(employee);
		return updatedEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		findEmployeeById(employeeId);
		employeeService.deleteById(employeeId);
		return "Deleted Employee Id - " + employeeId;
	}
}
