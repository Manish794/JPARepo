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
@Table(name="lab5_student")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="sname", length = 25)
    private String name;

    @Column(name="semail", length = 50)
    private String email;

}
