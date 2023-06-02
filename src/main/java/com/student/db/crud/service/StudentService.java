package com.student.db.crud.service;

import com.student.db.crud.entity.Student;
import java.util.List;

public interface StudentService {

    //add student
    Student addStudent(Student student);

    //get Student by id
    Student getStudent(int id);

    //get all students
    List<Student> getAllStudents();

    // update Student by id
    Student updateStudent(Student student, int id);

    // delete student by id
    void deleteStudent(int id);
}
