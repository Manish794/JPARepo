package com.jpa.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="lab2_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="sname", length = 25)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="lab2_emails", joinColumns = @JoinColumn(name="sid"))
    @Column(name="semail", length = 50)
    private List<String> emails;

    @ElementCollection
    @CollectionTable(name="lab2_phones", joinColumns = @JoinColumn(name="sid"))
    @Column(name="sphone")
    private Set<Long> phones;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="lab2_marks", joinColumns = @JoinColumn(name="sid"))
    @MapKeyColumn(name="subject")
    @Column(name="marksObtained")
    private Map<String, Integer> marks;


}
