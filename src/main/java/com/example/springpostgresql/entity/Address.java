package com.example.springpostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"id"})
@ToString
public class Address {

    @Id
    @SequenceGenerator(name="seq_person_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String address;
    private AddressType addressType;
    private boolean active;

    enum AddressType {
        HOME,
        WORK,
        OTHER
    }
}
