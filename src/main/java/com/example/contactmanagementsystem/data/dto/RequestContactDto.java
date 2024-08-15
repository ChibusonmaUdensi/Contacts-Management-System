package com.example.contactmanagementsystem.data.dto;

// import com.example.contactmanagementsystem.data.model.PhoneBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestContactDto {



    private String firstName;
    private String lastName;
    private String address;

    private Long id;
   private Long phoneBookId;
    private String phoneNumber;
    private String email;


}
