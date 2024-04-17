package com.parsakav.bookstore.controller;


import com.parsakav.bookstore.request.UserRegisterRequest;
import com.parsakav.bookstore.response.UserRegisterResponse;
import com.parsakav.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {

        return userService.save(userRegisterRequest);

    }


}
