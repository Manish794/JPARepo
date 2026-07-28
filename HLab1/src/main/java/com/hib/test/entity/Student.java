package com.hib.test.entity;

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
@Table(name="mystudents")
public class Student implements Serializable {

    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studId;

    @Column(name = "sname", length = 25)
    private String studentName;

    private String email;
    private long phone;

    @Column(length = 50)
    private String password;

    @Column(name = "doj")
    private LocalDate joiningDate;


}
