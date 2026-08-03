package com.jpa.test.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentId implements Serializable {

    private int id;
    private String batch;

}
