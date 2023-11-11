package com.sa.paniwala.cruddemo.dao;

import java.util.List;

import com.sa.paniwala.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int employeeId);
	public Employee save(Employee employee);
	public void deleteById(int employeeId);
}
