package com.sa.paniwala.cruddemo.service;

import java.util.List;

import com.sa.paniwala.cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> listEmployees();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);
}
