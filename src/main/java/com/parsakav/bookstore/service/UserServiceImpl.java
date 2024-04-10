package com.parsakav.bookstore.service;

import com.parsakav.bookstore.entity.UserEntity;
import com.parsakav.bookstore.repository.UserEntityRepository;
import com.parsakav.bookstore.request.UserRegisterRequest;
import com.parsakav.bookstore.response.UserRegisterResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResponse save(UserRegisterRequest userRegisterRequest) {
        userRegisterRequest.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));

        UserEntity user = new UserEntity();

        BeanUtils.copyProperties(userRegisterRequest, user);
        user = userEntityRepository.save(user);
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        BeanUtils.copyProperties(user, userRegisterResponse);
        return userRegisterResponse;
    }
}
