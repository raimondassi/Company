package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClientDto {

    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String phone;
    private String email;

}


