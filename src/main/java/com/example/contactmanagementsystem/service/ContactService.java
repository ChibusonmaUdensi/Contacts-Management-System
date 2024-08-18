package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(RequestContactDto requestContactDto);
    String deleteContact(String id);
    List <Contact> findAllContacts();
    Contact findContactById(String id);
    Contact updateContact (RequestContactDto requestContactDto);

    Contact findContactsByName(String name);

}
