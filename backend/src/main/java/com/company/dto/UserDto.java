package com.company.dto;

import com.company.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String username;

    public UserDto(User user) {
        username = user.getUsername();

    }
}
