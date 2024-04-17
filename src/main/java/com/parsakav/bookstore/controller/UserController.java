package com.parsakav.bookstore.controller;


import com.parsakav.bookstore.dto.UserDto;
import com.parsakav.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;


    @PreAuthorize("!isAuthenticated()")
    @PostMapping
    public ResponseEntity<UserDto.Output> register(@RequestBody UserDto.Input userRegisterRequest) {

        return ResponseEntity.ok(userService.save(userRegisterRequest));

    }


}
