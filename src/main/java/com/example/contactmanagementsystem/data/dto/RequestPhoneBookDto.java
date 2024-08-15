package com.example.contactmanagementsystem.data.dto;

import com.example.contactmanagementsystem.data.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class RequestPhoneBookDto {

    private Long Id;
    private List<Contact> contacts;

}
