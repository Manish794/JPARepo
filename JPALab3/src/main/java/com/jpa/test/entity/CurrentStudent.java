package com.jpa.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab3_curr_student")
@PrimaryKeyJoinColumn(name = "sid")

public class CurrentStudent extends Student {

    private String session;

    private String timing;

    @Override
    public String toString() {
        return "CurrentStudent{" +
                "session='" + session + '\'' +
                ", timing='" + timing + '\'' +
                "} " + super.toString();
    }
}
