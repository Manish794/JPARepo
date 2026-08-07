package com.jpa.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeGroupByData {
    private String ecity;
    private long count;
    private double totalsal;
}
