package com.example.contactmanagementsystem.data.dto;
import com.example.contactmanagementsystem.data.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPhoneBookDto {

    @Id
    private String id;

    private List<Contact> contacts;

}
