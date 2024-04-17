package com.parsakav.bookstore.service;

import com.parsakav.bookstore.request.UserRegisterRequest;
import com.parsakav.bookstore.response.UserRegisterResponse;

public interface UserService {

    public UserRegisterResponse save(UserRegisterRequest request);
}
