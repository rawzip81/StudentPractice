package com.rajeeb.studentpractice.service;

import com.rajeeb.studentpractice.dto.StudentDto;
import com.rajeeb.studentpractice.entity.Student;
import com.rajeeb.studentpractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public List<Student> getStudentByNameAndAddress(String name, String address) {
        return studentRepository.getStudentByNameAndAddress(name, address);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public List<Student> getStudentByAddress(String address) {
        return studentRepository.getStudentByAddress(address);
    }
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student insertStudentName(Student student) {
        return studentRepository.save(student);
    }

    public String deleteById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(exists){
        studentRepository.deleteById(id);
        return "Deleted";}
        return "ID Not Found";
    }

    public Student updateStudentById(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> deleteByEmail(String email) {
        return studentRepository.deleteStudentByEmail(email);
    }





}
