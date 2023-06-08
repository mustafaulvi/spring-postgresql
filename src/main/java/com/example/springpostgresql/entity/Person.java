package com.example.springpostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person",allocationSize = 1)
    @GeneratedValue(generator = "sqe_person",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String surName;

    @OneToMany
    @JoinColumn(name="person_address_id")
    private List<Address> addresses;
}
