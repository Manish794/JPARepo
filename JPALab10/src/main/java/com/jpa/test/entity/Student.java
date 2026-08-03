package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab10_student")
public class Student implements Serializable {

    @SidValue
    @EmbeddedId
    private StudentId sid;

    @Column(name="sname", length = 25)
    private String name;

    @Column(name="semail", length = 50)
    private String email;

    @Column(name="sphone")
    private Long phone;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + sid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
