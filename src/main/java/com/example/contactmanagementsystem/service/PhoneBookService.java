package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import org.springframework.stereotype.Service;

@Service
public interface PhoneBookService {

    PhoneBook createPhoneBook();
    String deletePhonebook (String id);
    PhoneBook findPhoneBookById(String id);

}
