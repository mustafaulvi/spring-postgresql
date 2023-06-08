package com.example.springpostgresql.services.impl;

import com.example.springpostgresql.dto.PersonDto;
import com.example.springpostgresql.entity.Address;
import com.example.springpostgresql.entity.Person;
import com.example.springpostgresql.repo.AddressRepository;
import com.example.springpostgresql.repo.PersonRepository;
import com.example.springpostgresql.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        Assert.notNull(personDto.getName(), "The Name field is required!");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurName(personDto.getSurName());
        final  Person personDB = personRepository.save(person);

        List<Address> list = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(personDB);
            list.add(address);
        });
        addressRepository.saveAll(list);
        personDto.setId(personDB.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();

        personList.forEach(it -> {
            PersonDto personDto =new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setSurName(it.getSurName());
            personDto.setAddresses(
                    it.getAddresses() != null ?
                            it.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList())
                            : null);
            personDtoList.add(personDto);
        });
        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(PersonDto pageable) {
        return null;
    }
}
