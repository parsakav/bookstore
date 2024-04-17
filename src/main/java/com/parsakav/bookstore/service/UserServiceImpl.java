package com.parsakav.bookstore.service;

import com.parsakav.bookstore.dto.UserDto;
import com.parsakav.bookstore.entity.RoleEntity;
import com.parsakav.bookstore.entity.UserEntity;
import com.parsakav.bookstore.repository.UserEntityRepository;
import com.parsakav.bookstore.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto.Output save(UserDto.Input userRegisterRequest) {
        userRegisterRequest.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        UserEntity user = UserDto.Input.mapping(userRegisterRequest);

        RoleEntity userRoleEntity = new RoleEntity(ApplicationUserRole.USER_ID,
                ApplicationUserRole.USER);

        user.setUserRoleEntities(List.of(userRoleEntity));

        user = userEntityRepository.save(user);
        UserDto.Output userRegisterResponse = UserDto.Output.mapping(user);
        return userRegisterResponse;
    }

    @Override
    public UserDto.Output findByPhonenumber(String phoneNumber) {
        UserEntity user = userEntityRepository.getUserEntityWithRoles(phoneNumber).get();
        user.getUserRoleEntities();

        return UserDto.Output.mapping(user);
    }


}
