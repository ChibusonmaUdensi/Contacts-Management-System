package com.example.contactmanagementsystem.web;
import java.util.List;
import com.example.contactmanagementsystem.data.dto.RequestPhoneBookDto;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.service.ContactService;
import com.example.contactmanagementsystem.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contact")
public class PhoneBookController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping("/getAllPhonebooks")
    public ResponseEntity<List<PhoneBook>> getAll() {
        List<PhoneBook> phonebooks = phoneBookService.findAllPhoneBooks();
        return new ResponseEntity<>(phonebooks, HttpStatus.OK);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<PhoneBook> getById(@PathVariable("id") @RequestParam Long id) {
        PhoneBook phoneBook = phoneBookService.findPhoneBookById(id);
        return new ResponseEntity<>(phoneBook, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PhoneBook> create(@RequestBody RequestPhoneBookDto requestPhoneBookDto) {
        PhoneBook newPhoneBook = phoneBookService.savePhoneBook(requestPhoneBookDto);
        return new ResponseEntity<>(newPhoneBook, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PhoneBook> update(@RequestBody RequestPhoneBookDto requestPhoneBookDto) {
        PhoneBook phoneBookToUpdate = phoneBookService.updatePhoneBook(requestPhoneBookDto);
        return new ResponseEntity<>(phoneBookToUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        phoneBookService.removePhoneBook(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}