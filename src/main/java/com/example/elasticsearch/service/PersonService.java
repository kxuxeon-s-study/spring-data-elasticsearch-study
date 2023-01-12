package com.example.elasticsearch.service;

import com.example.elasticsearch.document.Person;
import com.example.elasticsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void save(final Person person) {
        personRepository.save(person);
    }

    public Person findById(final String id) {
        return personRepository.findById(id).orElse(null);
    }
}
