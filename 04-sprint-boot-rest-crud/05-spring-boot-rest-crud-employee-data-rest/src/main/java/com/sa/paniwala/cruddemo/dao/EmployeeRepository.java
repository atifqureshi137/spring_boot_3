package com.sa.paniwala.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.paniwala.cruddemo.entity.Employee;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
