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
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts = contactService.findAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<Contact> getById(@PathVariable String id) {
        Contact contact = contactService.findContactById(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact);
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> create(@RequestBody RequestContactDto requestContactDto) {
        Contact newContact = contactService.createContact(requestContactDto);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PutMapping("/contact/update")
    public ResponseEntity<Contact> update(@RequestBody RequestContactDto requestContactDto) {
        Contact contactToUpdate = contactService.updateContact(requestContactDto);
        return new ResponseEntity<>(contactToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/contact/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contacts/{firstName}")
    public ResponseEntity<HttpStatus> findByName(@RequestParam String firstName) {
        contactService.findContactsByName(firstName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
