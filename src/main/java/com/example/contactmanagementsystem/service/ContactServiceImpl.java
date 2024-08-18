package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.Contact;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.ContactRepository;
import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
   private PhoneBookRepository phoneBookRepository;

    PhoneBook createdPhoneBook = new PhoneBook();

    @Override
    public Contact createContact(RequestContactDto requestContactDto) {
        findByEmail(requestContactDto.getEmail());
        findByPhoneNumber(requestContactDto.getPhoneNumber());
            Contact contact = new Contact();
            contact.setFirstName(requestContactDto.getFirstName());
            contact.setLastName(requestContactDto.getLastName());
            contact.setAddress(requestContactDto.getAddress());
            contact.setPhoneNumber(requestContactDto.getPhoneNumber());
            contact.setEmail(requestContactDto.getEmail());
            contactRepository.save(contact);
            createdPhoneBook.addContact(contact);
           return contact;

        }

    @Override
    public String deleteContact(String id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
            System.out.println("Contact deleted");
            return "Contact deleted";
        } else {
            throw new NullPointerException("Contact does not exist");
        }
    }

    @Override
    public List<Contact> findAllContacts() {

        return contactRepository.findAll();
    }

    @Override
    public Contact findContactById(String id) {
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
            throw new RuntimeException("Contact Not Found fishpieeeeeeeeee");

        }
    }

    @Override
    public Contact findContactsByName(String name) {
        Optional<Contact> names = contactRepository.findByFirstName(name);
        if (names.isPresent()) {
            return names.get();

        } else {
            throw new NullPointerException();
        }

    }

    private void findByEmail(String email){
      Optional<Contact> contact = contactRepository.findByEmail(email);
      if(contact.isPresent()) throw new RuntimeException("Email Address already exists");
    }
    private void findByPhoneNumber(String phoneNumber){
        Optional<Contact> number = contactRepository.findByPhoneNumber(phoneNumber);
        if(number.isPresent()) throw new RuntimeException("PhoneNumber already exists");
    }
}
