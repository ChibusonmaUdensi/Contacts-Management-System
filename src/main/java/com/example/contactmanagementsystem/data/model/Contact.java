package com.example.contactmanagementsystem.data.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString(exclude = "phoneBook")
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contact")
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    @Id
    private String id;
    private String phoneNumber;
    private String email;
    @JsonIgnore
    @DBRef
    private PhoneBook phoneBook;
}