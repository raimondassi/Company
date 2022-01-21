package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.LOGIN)
public class LoginController {

    @PostMapping
    public UserDto login(@AuthenticationPrincipal User user) {
        return new UserDto(user);
    }
}
