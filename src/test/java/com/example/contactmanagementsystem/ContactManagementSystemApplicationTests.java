package com.example.contactmanagementsystem;
import com.example.contactmanagementsystem.data.dto.RequestContactDto;
import com.example.contactmanagementsystem.data.model.PhoneBook;
import com.example.contactmanagementsystem.data.repository.ContactRepository;
import com.example.contactmanagementsystem.service.ContactService;
import com.example.contactmanagementsystem.service.PhoneBookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.contactmanagementsystem.data.model.Contact;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactManagementSystemApplicationTests {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    @Autowired
    private PhoneBookService phoneBookService;

    @BeforeEach
    public void tearDown(){
        contactRepository.deleteAll();
    }

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
        PhoneBook createPhoneBook = new PhoneBook();
        RequestContactDto requestContactDto = new RequestContactDto();

        requestContactDto.setEmail("lambo@gmail.com");
        requestContactDto.setAddress("3 Yaba");
        requestContactDto.setFirstName("Ope");
        requestContactDto.setLastName("Lee");
        requestContactDto.setPhoneNumber("08044556677");
        Contact contact = contactService.createContact(requestContactDto);
        createPhoneBook.addContact(contact);
        System.out.println(contact);
        assertEquals(1, createPhoneBook.getContact());
    }

    @Test
    public void testThatContactExists(){
        PhoneBook phoneBook = new PhoneBook();
        PhoneBook createdPhoneBook = phoneBookService.createPhoneBook();
        RequestContactDto requestContactDto = new RequestContactDto();
        requestContactDto.setEmail("Mudenc@gmail.com");
        requestContactDto.setAddress("ikorodu");
        requestContactDto.setPhoneNumber("419666");
        requestContactDto.setFirstName("Anon");
        requestContactDto.setLastName("Rex");
        Contact contact = contactService.createContact(requestContactDto);
        List<Contact> contactSearch = contactService.findAllContacts();
        assertEquals(contactSearch.size(), 1);
        System.out.println("The id: " +  contact.getId());

         }

    @Test
    public void testThatCanUpdateContact(){
        PhoneBook phoneBook = new PhoneBook();
        PhoneBook createdPhoneBook = phoneBookService.createPhoneBook();
        RequestContactDto requestContactDto = new RequestContactDto();
        requestContactDto.setEmail("lambo@gmail.com");
        requestContactDto.setAddress("3 Yaba");
        requestContactDto.setFirstName("Ope");
        requestContactDto.setLastName("Lee");
       Contact contact =  contactService.createContact(requestContactDto);
        List<Contact> contactSearch = contactService.findAllContacts();
        assertEquals(contactSearch.size(), 1);
        Contact c = contactService.findContactById(contact.getId());
        System.out.println("The contact: " + c);
        String id = c.getId();
        System.out.println(id);
        requestContactDto.setId(id);
        requestContactDto.setEmail("harry03@gmail.com");
        requestContactDto.setAddress("4 sabo");
       requestContactDto.setFirstName("harry");
        requestContactDto.setLastName("nwangogo");
        requestContactDto.setPhoneNumber("08149661102");
      Contact update = contactService.updateContact(requestContactDto);
        List<Contact> contactSearches = contactService.findAllContacts();
        assertEquals(contactSearches.size(), 1);
        System.out.println(update.getFirstName());


}
    @Test
    public void testThatPhoneBookWorks(){
        PhoneBook phoneBook = new PhoneBook();
        assertTrue(phoneBook.getContactsStore().isEmpty());
        PhoneBook createdPhoneBook = phoneBookService.createPhoneBook();
        System.out.println(phoneBook.getContactsStore());
        RequestContactDto requestContactDto = new RequestContactDto();
        requestContactDto.setEmail("lambo@gmail.com");
        requestContactDto.setAddress("3 Yaba");
        requestContactDto.setFirstName("Ope");
        requestContactDto.setLastName("Lee");
        requestContactDto.setPhoneNumber("12222222222222222");
        contactService.createContact(requestContactDto);
        List<Contact> contactSearch = contactService.findAllContacts();
        assertEquals(contactSearch.size(), 1);
        phoneBook.setContactsStore(contactSearch);
        System.out.println(phoneBook.getContactsStore());
    }

@Test
    public void testThatContactDeletes(){
    PhoneBook phoneBook = new PhoneBook();
    PhoneBook createdPhoneBook = phoneBookService.createPhoneBook();
    RequestContactDto requestContactDto = new RequestContactDto();
    requestContactDto.setEmail("or@mail.uk");
    requestContactDto.setLastName("Orga");
    requestContactDto.setFirstName("Lact");
    requestContactDto.setPhoneNumber("419666");
    Contact contact = contactService.createContact(requestContactDto);
    System.out.println(contact.getId());
    List<Contact> contactList =contactService.findAllContacts();
        assertEquals(contactList.size(), 1);
        System.out.println(phoneBook.getContactsStore());
      String delete = contactService.deleteContact(contact.getId());
    contactList =contactService.findAllContacts();
    assertEquals(contactList.size(), 0);
    System.out.println(delete);
    }
}

