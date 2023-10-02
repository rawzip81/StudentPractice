package com.rajeeb.studentpractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")

public class Student {
@Id
@SequenceGenerator( name="students_sequence",
                    sequenceName = "students_sequence",
                    initialValue = 1,
                    allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_sequence")
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id")
    private Parent parent;


}