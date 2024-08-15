package com.example.contactmanagementsystem.data.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "phonebook")
public class PhoneBook {
    private Long id;
  //  private String name;
//    @DBRef
//
//@OneToMany
    private List <Contact> contacts;

}
