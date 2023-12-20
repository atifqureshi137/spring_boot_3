package com.sa.paniwala.springboot.thymeleafdemo.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.paniwala.springboot.thymeleafdemo.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findAllByOrderByLastNameAsc();
}
