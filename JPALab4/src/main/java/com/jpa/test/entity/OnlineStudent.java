package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity

@DiscriminatorValue(value = "ON_STU")
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
