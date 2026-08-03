package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab6_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="sname", length = 25)
    private String name;

    @Column(name="semail", length = 50)
    private String email;

    @Column(name="sphone")
    private Long phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "add_id")
    private Address address;

}
