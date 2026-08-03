package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab6_address")

public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    @Column(length = 50)
    private String street;

    @Column(length = 50)
    private String city;

    private int pin;

    @OneToOne(mappedBy = "address")
    private Student student;

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }
}
