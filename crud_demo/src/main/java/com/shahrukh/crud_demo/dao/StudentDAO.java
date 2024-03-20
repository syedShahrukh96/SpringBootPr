package com.shahrukh.crud_demo.dao;

import com.shahrukh.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findALl();

    List<Student> findByLastName(String theLastName);


}
