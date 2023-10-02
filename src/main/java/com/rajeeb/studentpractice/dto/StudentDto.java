package com.rajeeb.studentpractice.dto;

import com.rajeeb.studentpractice.entity.Parent;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private Parent parent;
}
