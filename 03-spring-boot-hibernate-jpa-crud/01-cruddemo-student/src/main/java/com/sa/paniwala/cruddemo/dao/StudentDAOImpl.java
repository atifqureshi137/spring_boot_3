package com.sa.paniwala.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sa.paniwala.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// Define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	@Override
	public List<Student> findAll() {
		TypedQuery<Student> students = entityManager.createQuery("from Student order by lastName desc", Student.class);
		return students.getResultList();
	}
	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> students = entityManager.createQuery("from Student where lastName=:lastName", Student.class);
		students.setParameter("lastName", lastName);
		return students.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = findById(id);
		if (null != student) {
			entityManager.remove(student);
		}
	}
}
