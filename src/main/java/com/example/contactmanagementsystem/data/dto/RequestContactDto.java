package com.example.contactmanagementsystem.data.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestContactDto {



    private String firstName;
    private String lastName;
    private String address;

    private String id;
    private String phoneNumber;
    private String email;


}
