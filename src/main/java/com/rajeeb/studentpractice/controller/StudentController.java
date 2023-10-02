package com.rajeeb.studentpractice.controller;

import com.rajeeb.studentpractice.dto.DtoMapper;
import com.rajeeb.studentpractice.dto.StudentDto;
import com.rajeeb.studentpractice.entity.Student;
import com.rajeeb.studentpractice.response.Response;
import com.rajeeb.studentpractice.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getStudent(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "address", required = false) String address){
        if(StringUtils.hasLength(name) && StringUtils.hasLength(address))
        return new ResponseEntity(studentService.getStudentByNameAndAddress(name, address), HttpStatus.OK);
        else if(StringUtils.hasLength(name))
            return new ResponseEntity(studentService.getStudentByName(name), HttpStatus.OK);
        else if (StringUtils.hasLength(address))
            return new ResponseEntity(studentService.getStudentByAddress(address), HttpStatus.OK);
        else
            return new ResponseEntity(studentService.getAllStudent(), HttpStatus.OK);
        }

    @GetMapping(path = "/{id}")
    public Response<Student> getStudentById(@PathVariable("id") Long id, Student student){
        if(id != student.getId()){
            return new Response("BAD_REQUEST", "400" );
        }
        return new Response("OK", "200",studentService.getStudentById(id));

    }
    @PostMapping
    public Optional<ResponseEntity<Student>> insertStudent(@RequestBody StudentDto studentDto){
        DtoMapper dtoMapper = new DtoMapper();
        Student student = dtoMapper.toStudentEntity(studentDto);
        StudentDto studentDto1 = dtoMapper.toStudentDto(studentService.insertStudentName(student));
        return Optional.of(new ResponseEntity(studentDto1, HttpStatus.OK));
    }
    @DeleteMapping(path = "/{id}")
    public Response<String> deleteStudentById(@PathVariable("id") Long id){
        return new Response(studentService.deleteById(id));
    }
    @Transactional
    @DeleteMapping(path = "/email")
    public Response<Optional<Student>> deleteStudentByEmail(@RequestParam(value = "email") String email){
       return new Response("Ok", "200", studentService.deleteByEmail(email));
    }
    @PutMapping
    public Response<Optional<Student>> updateStudent(@RequestParam Long id, @RequestBody Student student){
        if(id != student.getId()){
            return new Response("BAD_REQUEST", "400");
        }
        return new Response("SUCCESS", "200", studentService.updateStudentById(student));
    }
}

