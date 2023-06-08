package com.example.springpostgresql.services;

import com.example.springpostgresql.dto.PersonDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    void delete(Long id);

    List<PersonDto> getAll();

    Page<PersonDto> getAll(PersonDto pageable);
}
