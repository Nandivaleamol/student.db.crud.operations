package com.student.db.crud.service.impl;

import com.student.db.crud.entity.Student;
import com.student.db.crud.repository.StudentRepository;
import com.student.db.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Not Found With Id "+id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, int id) {
        var existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found With Id " + id));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        existingStudent.setAddress(student.getAddress());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(int id) {
        var existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found With Id " + id));
        studentRepository.delete(existingStudent);
    }
}
