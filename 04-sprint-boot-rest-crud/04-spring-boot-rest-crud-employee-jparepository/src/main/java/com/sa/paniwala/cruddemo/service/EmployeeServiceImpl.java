package com.sa.paniwala.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.paniwala.cruddemo.dao.EmployeeRepository;
import com.sa.paniwala.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	} 
	
	@Override
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if (result.isEmpty()) {
			throw new RuntimeException("Did no find employee id -" + id);
		}
		
		theEmployee = result.get();
		return theEmployee;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
