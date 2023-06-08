package com.example.springpostgresql.repo;

import com.example.springpostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
