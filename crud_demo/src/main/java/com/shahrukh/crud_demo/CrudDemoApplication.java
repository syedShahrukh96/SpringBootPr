package com.shahrukh.crud_demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.shahrukh.crud_demo.dao.StudentDAO;
import com.shahrukh.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all student");
		int numberRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numberRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("shaik");


		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findALl();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student Object...");
		Student tempStudent = new Student("Daffy", "Duck", "Daffy@gmail.com");

		//save the student
		System.out.println("saveing the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id: "+theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the Student: " +myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student student1 = new Student("alok", "ranjan", "alok@gmail.com");
		Student student2 = new Student("Hashim", "Shaik", "Hashim@gmail.com");
		Student student3 = new Student("siraj", "shaik", "Siraj@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("creating new student object..");
		Student tempStudent = new Student("shahrukh", "syed", "shahukh@gmail.com");


		//save the student object
		System.out.println("saving the student");
		studentDAO.save(tempStudent);


		//display id of the saved student
		System.out.println("saved student. Generated id: "+ tempStudent.getId());
	}



}
