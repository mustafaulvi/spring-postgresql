package com.example.springpostgresql.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class PersonDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> addresses;
}
