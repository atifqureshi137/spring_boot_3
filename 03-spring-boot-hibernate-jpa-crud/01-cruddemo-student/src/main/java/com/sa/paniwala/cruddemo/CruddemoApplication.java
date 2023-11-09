package com.sa.paniwala.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sa.paniwala.cruddemo.dao.StudentDAO;
import com.sa.paniwala.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			Student student = createStudent(studentDao);
			readStudent(studentDao, student);
			//findAllStudent(studentDao);
			//findStudentsByTheLastName(studentDao, student.getLastName());
			//updateStudent(studentDao, student);
			//deleteStudent(studentDao);
		};
	}
	
	private void findStudentsByTheLastName(StudentDAO studentDao, String lastName) {
		for(Student student :studentDao.findByLastName(lastName)) {
			System.out.println("Student : " + student.toString());
		}		
	}

	private void findAllStudent(StudentDAO studentDao) {
		for(Student student :studentDao.findAll()) {
			System.out.println("Student : " + student.toString());
		}
	}
	
	private Student createStudent(StudentDAO studentDao) {
		// Create the Student
		Student student = new Student("Atif10", "Qureshi10", "atif.qureshi138@gmail.com");
		// Save the Student
		studentDao.save(student);
		
		//Display the id of the student
		System.out.println("Saved Student id :" + student.getId());
		return student;
	}
	
	private void readStudent(StudentDAO studentDao, Student std) {
		Student student = studentDao.findById(std.getId());
		System.out.println("Saved student. Generated Id: " + student.toString());		
	}
	
	private  void updateStudent(StudentDAO studentDao, Student student) {
		student.setFirstName("Mr scooby");
		studentDao.update(student);
		Student scoobyStudent = studentDao.findById(student.getId());
		System.out.println("student first name :" + scoobyStudent.toString());
	}
	
	private void deleteStudent(StudentDAO studentDao) {
		int deleteStudentById = 9;
		studentDao.delete(deleteStudentById);
		System.out.println("-------------------------------");
		findAllStudent(studentDao);
	}
}
