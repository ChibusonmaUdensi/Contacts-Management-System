package com.example.contactmanagementsystem.service;

import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.Contact;

import java.util.List;

public interface ContactService {
    Contact saveContact(RequestContactDto requestContactDto);
    String deleteContact(Long id);
    List <Contact> findAllContacts();
    Contact findContactById(Long id);
    Contact updateContact (RequestContactDto requestContactDto);

}
