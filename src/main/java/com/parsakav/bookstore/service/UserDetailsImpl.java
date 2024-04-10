package com.parsakav.bookstore.service;

import com.parsakav.bookstore.entity.UserEntity;
import com.parsakav.bookstore.repository.UserEntityRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailsImpl implements  UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public UserDetailsImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user= userEntityRepository.getUserEntityWithRoles(username)
               .orElseThrow(()->{
           throw new UsernameNotFoundException("User not found");

       });

        List<GrantedAuthority> authority =  user.getUserRoleEntities()
                .stream()
                .map(e->new SimpleGrantedAuthority(e.getRoleByRoleId().getRoleName()))
                .collect(Collectors.toList());


           return new User(String.valueOf(user.getPhoneNumber()), user.getPassword(), authority);



    }
}
