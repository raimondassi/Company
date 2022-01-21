package com.company.controller;

import com.company.dto.CreateUserDto;
import com.company.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.ROOT + ApiPath.CREATEUSER)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createNewUser(createUserDto);
    }

}
