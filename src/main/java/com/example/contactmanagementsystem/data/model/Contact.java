package com.example.contactmanagementsystem.data.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contact")
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    @Id
    private Long id;
    private String phoneNumber;
    private String email;
}