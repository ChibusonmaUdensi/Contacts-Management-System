package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public PhoneBook createPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBookRepository.save(phoneBook);
        return phoneBook;
    }

    @Override
    public String deletePhonebook(String id) {
        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(id);
        if (phoneBook.isPresent()) {
            phoneBookRepository.delete(phoneBook.get());
            System.out.println("Phonebook deleted");
            return "Phonebook deleted";
        } else
           throw new NullPointerException("Phonebook not found");
    }

    @Override
    public PhoneBook findPhoneBookById(String id) {
        Optional<PhoneBook> findPhoneBook = phoneBookRepository.findById(id);
        if (findPhoneBook.isPresent()) {
            return findPhoneBook.get();
        } else {
            throw new RuntimeException("PhoneBook with id not found, mfjpm.");
        }
    }


    }
