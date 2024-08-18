package com.example.contactmanagementsystem.data.repository;
import com.example.contactmanagementsystem.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    Optional<Contact> findByEmail(String email);
    Optional<Contact> findByPhoneNumber(String phoneNumber);
    Optional<Contact>findByFirstName(String firstName);


}
