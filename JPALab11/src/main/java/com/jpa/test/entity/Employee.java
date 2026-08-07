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
        ),
        @NamedQuery(name="getByCityAndSal",
                query = "from Employee em where em.city=?1 and em.salary>?2 order by em.name ASC"
        ),
        @NamedQuery(name="getCityWiseCountAndTotalSal",
                query = "SELECT em.city, COUNT(em.salary), SUM(em.salary) FROM Employee em GROUP BY em.city HAVING em.city IN (?1)"
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
