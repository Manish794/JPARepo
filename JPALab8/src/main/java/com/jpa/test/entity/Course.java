package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab8_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="cname", length = 25)
    private String name;

    @Column(length = 50)
    private String duration;

    private int fee;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;


    @Override
    public String toString() {
        return "Course{" +
                "fee=" + fee +
                ", duration='" + duration + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
