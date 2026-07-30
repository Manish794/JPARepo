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
@Table(name="lab3_old_student")
@PrimaryKeyJoinColumn(name = "sid")
public class OldStudent extends Student {

    private int passingYear;

    @Column(length = 5)
    private String batchNo;

    @Override
    public String toString() {
        return "OldStudent{" +
                "passingYear=" + passingYear +
                ", batchNo='" + batchNo + '\'' +
                "} " + super.toString();
    }
}
