package com.example.contactmanagementsystem;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
//import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.ContactRepository;
//import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import com.example.contactmanagementsystem.service.ContactService;
import com.example.contactmanagementsystem.utils.GenerateId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.contactmanagementsystem.data.model.Contact;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactManagementSystemApplicationTests {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

//    @Autowired
//    private PhoneBookRepository phoneBookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testThatThereIsNoContact() {
        List<Contact> contacts = contactRepository.findAll();
        assertTrue(contacts.isEmpty());
    }

    @Test
    public void testThatContactSaves() {
        RequestContactDto requestContactDto = new RequestContactDto();
        requestContactDto.setId(GenerateId.generateId(new Random()));
        requestContactDto.setEmail("lambo@gmail.com");
        requestContactDto.setAddress("3 Yaba");
        requestContactDto.setFirstName("Ope");
        requestContactDto.setLastName("Lee");

        requestContactDto.setPhoneBookId(3888L);

         contactService.saveContact(requestContactDto);
        List<Contact> contactSearch = contactService.findAllContacts();
        assertEquals(contactSearch.size(), 6);
    }
}

