package com.jpa.test.entity;

import jakarta.persistence.Column;
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
@Table(name="lab3_on_student")
@PrimaryKeyJoinColumn(name = "sid")
public class OnlineStudent extends CurrentStudent {

    @Column(length = 50)
    private String joiningLink;

    @Column(length = 15)
    private String username;
    @Column(length = 15)
    private String password;

    @Override
    public String toString() {
        return "OnlineStudent{" +
                "joiningLink='" + joiningLink + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
