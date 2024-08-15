package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.dto.RequestPhoneBookDto;
import com.example.contactmanagementsystem.data.model.Contact;
import com.example.contactmanagementsystem.data.model.PhoneBook;

import java.util.List;
import java.util.Optional;
public interface PhoneBookService {

    PhoneBook savePhoneBook(RequestPhoneBookDto requestPhoneBookDto);
    boolean removePhoneBook(Long id);
    List<PhoneBook> findAllPhoneBooks();
    PhoneBook findPhoneBookById(Long id);
    PhoneBook updatePhoneBook(RequestPhoneBookDto requestPhoneBookDto);
}
