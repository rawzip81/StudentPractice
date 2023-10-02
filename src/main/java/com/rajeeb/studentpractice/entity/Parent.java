package com.rajeeb.studentpractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "parents")
public class Parent {
@Id
@SequenceGenerator(name = "sequence_parents", sequenceName = "sequence_parents", initialValue = 1, allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_parents")
    private Long p_id;
    private String name;
    private String phone;
}
