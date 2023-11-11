package com.sa.paniwala.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.paniwala.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> employees = entityManager.createQuery("from Employee", Employee.class);
		return employees.getResultList();
	}

	@Override
	public Employee findById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		Employee employee = findById(employeeId);
		entityManager.remove(employee);
	}
}