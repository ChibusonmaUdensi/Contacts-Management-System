package com.example.contactmanagementsystem.data.repository;


import com.example.contactmanagementsystem.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends MongoRepository<Contact, Long> {

}
