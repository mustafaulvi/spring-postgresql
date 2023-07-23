package com.example.springpostgresql.controller;

import com.example.springpostgresql.dto.PersonDto;
import com.example.springpostgresql.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson (){
        return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") long id,@RequestBody PersonDto personDto) {
        PersonDto personDtoNew = personService.update(id,personDto);
        if(personDtoNew.getFirstName() != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable("id") long id) {
        try {
            personService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
