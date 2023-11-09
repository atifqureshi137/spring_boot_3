package com.sa.paniwala.cruddemo.dao;

import java.util.List;

import com.sa.paniwala.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student student);
	void update(Student student);
	void delete(Integer id);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String lastName);
}
