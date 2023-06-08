package com.example.springpostgresql.repo;

import com.example.springpostgresql.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
