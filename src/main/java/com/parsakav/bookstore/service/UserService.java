package com.parsakav.bookstore.service;

import com.parsakav.bookstore.dto.UserDto;

public interface UserService {

    public UserDto.Output save(UserDto.Input request);

    public UserDto.Output findByPhonenumber(String phoneNumber);
}
