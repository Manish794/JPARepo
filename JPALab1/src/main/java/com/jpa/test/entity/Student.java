package com.jpa.test.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="students")
public class Student implements Serializable {

    @Id
    @Column(name="sid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="sname", length = 25)
    private String name;

    @Column(name="email", length = 50, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String password;

    private long phone;

    private LocalDate doj;

}
