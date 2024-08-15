package com.example.contactmanagementsystem.data.repository;

import com.example.contactmanagementsystem.data.model.PhoneBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneBookRepository extends MongoRepository<PhoneBook, Long> {



}
