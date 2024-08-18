package com.example.contactmanagementsystem.data.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "contactsStore")
@Document(collection = "phonebook")
public class PhoneBook {

    @Id
    private String id;


    @DBRef
    private List<Contact> contactsStore = new ArrayList<>();


    public void addContact(Contact contact) {
        contactsStore.add(contact);
    }
    public int getContact(){
        return contactsStore.size();
    }

}
