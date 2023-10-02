package com.rajeeb.studentpractice.repository;


import com.rajeeb.studentpractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> deleteStudentByEmail(String email);

    List<Student> getStudentById(Long id);

    List<Student> getStudentByNameAndAddress(String name, String address);

    List<Student> getStudentByName(String name);

    List<Student> getStudentByAddress(String address);


}
