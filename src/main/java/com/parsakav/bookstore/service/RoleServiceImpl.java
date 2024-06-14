package com.parsakav.bookstore.service;

import com.parsakav.bookstore.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserEntityRepository repository;

    @Override
    public String findRole(String username) {

        return repository.getUserEntityWithRoles(username).get().getUserRoleEntities().stream().findFirst().get().getRoleName();
    }
}
