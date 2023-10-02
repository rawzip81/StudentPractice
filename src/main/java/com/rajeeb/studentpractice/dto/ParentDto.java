package com.rajeeb.studentpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentDto {
    private Long p_id;
    private String name;
    private String phone;
}
