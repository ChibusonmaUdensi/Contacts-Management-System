package com.example.contactmanagementsystem.web;
import java.util.List;

import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.Contact;
import com.example.contactmanagementsystem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/contact/getById")
    public ResponseEntity<Contact> getById(@PathVariable("id") @RequestParam Long id) {
        Contact contact = contactService.findContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> create(@RequestBody RequestContactDto requestContactDto) {
        Contact newContact = contactService.saveContact(requestContactDto);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/contact/update")
    public ResponseEntity<Contact> update(@RequestBody RequestContactDto requestContactDto) {
        Contact contactToUpdate = contactService.updateContact(requestContactDto);
        return new ResponseEntity<>(contactToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/contact(/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
