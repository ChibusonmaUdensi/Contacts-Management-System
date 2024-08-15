package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.Contact;
import com.example.contactmanagementsystem.utils.GenerateId;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.ContactRepository;
//import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
   private PhoneBookRepository repository;

    private GenerateId generateId;
    @Override
    public Contact saveContact(RequestContactDto requestContactDto) {
            Contact contact = new Contact();
            contact.setId(GenerateId.generateId(new Random()));
            contact.setFirstName(requestContactDto.getFirstName());
            contact.setLastName(requestContactDto.getLastName());
            contact.setAddress(requestContactDto.getAddress());
            contact.setPhoneNumber(requestContactDto.getPhoneNumber());
            contact.setEmail(requestContactDto.getEmail());

        Optional<PhoneBook> phone = repository.findById(requestContactDto.getPhoneBookId());
        if (phone.isPresent()){
            PhoneBook phoneBook1 = phone.get();
            phoneBook1.getContacts();

            if (phoneBook1.getContacts() != null && !phoneBook1.getContacts().isEmpty()) {
                phoneBook1.getContacts().add(contact);
            }

            contactRepository.save(contact);
            repository.save(phoneBook1);
        }
        else {
            throw  new RuntimeException("PhoneBook doesn't exist");
        }

           return contact;
        }



    @Override
    public String deleteContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
            System.out.println("Contact deleted");
            return "Contact deleted";
        } else
            return "Contact not found";
    }

    @Override
    public List<Contact> findAllContacts() {

        return contactRepository.findAll();
    }

    @Override
    public Contact findContactById(Long id) {
        Optional<Contact> findContact = contactRepository.findById(id);
        if (findContact.isPresent()) {
            return findContact.get();
        } else {
            throw new RuntimeException("Contact with id not found, mfjpm.");
        }
    }

    @Override
    public Contact updateContact(RequestContactDto requestContactDto) {
        Optional<Contact> presentContact = contactRepository.findById(requestContactDto.getId());
        if (presentContact.isPresent()) {
            Contact contactToUpdate = presentContact.get();
            contactToUpdate.setLastName(requestContactDto.getLastName());
            contactToUpdate.setFirstName(requestContactDto.getFirstName());
            contactToUpdate.setEmail(requestContactDto.getEmail());
            contactToUpdate.setAddress(requestContactDto.getAddress());
            return contactRepository.save(contactToUpdate);
        } else {
            throw new RuntimeException("Contact Not Found");

        }
    }
}
