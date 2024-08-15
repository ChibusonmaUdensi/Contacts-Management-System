package com.example.contactmanagementsystem.service;
import com.example.contactmanagementsystem.data.dto.RequestPhoneBookDto;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public PhoneBook savePhoneBook(RequestPhoneBookDto requestPhoneBookDto) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setId(requestPhoneBookDto.getId());

        return phoneBookRepository.save(phoneBook);
    }

    @Override
    public boolean removePhoneBook(Long id) {
        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(id);
        if (phoneBook.isPresent()) {
            phoneBookRepository.delete(phoneBook.get());
            return true;
        }
        else return false;

 }

    @Override
    public List<PhoneBook> findAllPhoneBooks() {

        return phoneBookRepository.findAll();
    }

    @Override
    public PhoneBook findPhoneBookById(Long id) {
        Optional<PhoneBook> findPhoneBook = phoneBookRepository.findById(id);
        if (findPhoneBook.isPresent()) {
            PhoneBook phoneBookFound = findPhoneBook.get();
            return phoneBookFound;
        } else {
            throw new RuntimeException("PhoneBook with id not found, mfjpm.");
        }
    }

    @Override
    public PhoneBook updatePhoneBook(RequestPhoneBookDto requestPhoneBookDto) {
        Optional<PhoneBook> presentPhoneBook =phoneBookRepository.findById(requestPhoneBookDto.getId());
        if (presentPhoneBook.isPresent()) {
           PhoneBook phoneBookToUpdate = presentPhoneBook.get();
         //  phoneBookToUpdate.setName(requestPhoneBookDto.getName());
            return phoneBookRepository.save(phoneBookToUpdate);
        } else {
            throw new RuntimeException("Contact Not Found");
        }
    }
}