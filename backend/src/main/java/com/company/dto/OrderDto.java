package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDto {

    private ClientDto client;
    private String description;
    private String picture;
    private String username;
}
