package com.rajeeb.studentpractice.dto;

import com.rajeeb.studentpractice.entity.Parent;
import com.rajeeb.studentpractice.entity.Student;

public class DtoMapper {
   public StudentDto toStudentDto(Student student){
       StudentDto studentDto = new StudentDto();
       studentDto.setId(student.getId());
       studentDto.setName(student.getName());
       studentDto.setPhone(student.getPhone());
       studentDto.setEmail(student.getEmail());
       studentDto.setAddress(student.getAddress());
      return studentDto;
   }
   public Student toStudentEntity(StudentDto studentDto){
    Student student = new Student();
       student.setId(studentDto.getId());
       student.setName(studentDto.getName());
       student.setPhone(studentDto.getPhone());
       student.setEmail(studentDto.getEmail());
       student.setAddress(studentDto.getAddress());
       student.setParent(studentDto.getParent());
    return student;
   }

   public ParentDto toParentDto(Parent parent){
      ParentDto parentDto = new ParentDto();
      parentDto.setP_id(parent.getP_id());
      parentDto.setName(parent.getName());
      parentDto.setPhone(parent.getPhone());
      return parentDto;
   }

   public Parent toParentEntity(ParentDto parentDto){
       Parent parent = new Parent();
       parent.setP_id(parentDto.getP_id());
       parent.setName(parentDto.getName());
       parent.setPhone(parentDto.getPhone());
       return parent;
   }
}
