package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


@NamedQueries({
        @NamedQuery(name="getAll",
        query = "from Employee em"
        )
})

@Entity
@Table(name="myemployee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;

    @Column(name="ename", length = 25)
    private String name;

    @Column(name="eemail", length = 50)
    private String email;

    @Column(name="ecity", length = 25)
    private String city;

    @Column(name="esalary")
    private double salary;

    @Override
    public String toString() {
        return
                "id=" + eid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + city + '\'' +
                ", salary=" + salary ;

    }
}
