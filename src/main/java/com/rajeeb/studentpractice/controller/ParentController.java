package com.rajeeb.studentpractice.controller;

import com.rajeeb.studentpractice.dto.DtoMapper;
import com.rajeeb.studentpractice.dto.ParentDto;
import com.rajeeb.studentpractice.entity.Parent;
import com.rajeeb.studentpractice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/parents")
public class ParentController {
    @Autowired
    private ParentService parentService;
    @GetMapping
    public List<Parent> getAllParents(Parent parent){
        return parentService.getAllParents(parent);
    }
    @PostMapping
    public ResponseEntity<Parent> insertParentDetails(@RequestBody ParentDto parentDto){
        DtoMapper dtoMapper = new DtoMapper();
        Parent parent = dtoMapper.toParentEntity(parentDto);
        ParentDto parentDto1 = dtoMapper.toParentDto(parentService.insertParentDetails(parent));
       return new ResponseEntity(parentDto1, HttpStatus.OK);

    }
    @DeleteMapping(path = "/{p_id}")
    public void deleteParentById(@PathVariable("p_id") Long p_id){
        parentService.deleteParentById(p_id);
    }
    @PutMapping
    public Optional<ResponseEntity<Parent>> updateParentById(@RequestParam Long p_id, @RequestBody Parent parent){
        if(p_id != parent.getP_id()){
            return Optional.of(new ResponseEntity(HttpStatus.BAD_REQUEST));
        }
        return Optional.of(new ResponseEntity(parentService.updateParentById(parent), HttpStatus.OK));
    }

}
