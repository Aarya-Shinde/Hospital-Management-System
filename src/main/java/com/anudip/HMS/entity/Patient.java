package com.anudip.HMS.entity;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //The patient id is amtomatically being generated
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String contact;

    private String disease;
    private String doctor;
}
