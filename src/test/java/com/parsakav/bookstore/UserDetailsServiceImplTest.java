package com.parsakav.bookstore;

import com.parsakav.bookstore.entity.RoleEntity;
import com.parsakav.bookstore.entity.UserEntity;
import com.parsakav.bookstore.entity.UserRoleEntity;
import com.parsakav.bookstore.repository.UserEntityRepository;
import com.parsakav.bookstore.security.ApplicationUserRole;
import com.parsakav.bookstore.service.UserDetailsImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDetailsServiceImplTest {


    private PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    @Mock
    private UserEntityRepository userEntityRepository;

    private UserEntity testUser=null;

    @BeforeEach
    public void before(){
        userDetailsService = new UserDetailsImpl(userEntityRepository);
        testUser= new UserEntity();
        testUser.setPhoneNumber("1");
        testUser.setEmail("1");
        testUser.setId(1);
        testUser.setFullname("1");
        testUser.setPassword("$2a$10$bubZgWBtPfVRoi53NhvnL.EbH3FTnA3N.9mUF/Tm5pqL4RoNpgP6a");
        testUser.setPostalcode(1);
        Collection<UserRoleEntity> roleEntities = new ArrayList<>();
        testUser.setUserRoleEntities(roleEntities);
        UserRoleEntity ur= new UserRoleEntity();
        RoleEntity r = new RoleEntity();
        ur.setRoleByRoleId(r);
        r.setRoleName(ApplicationUserRole.USER);
        roleEntities.add(ur);
    }

    private UserDetailsService userDetailsService;

    @Test
    @Order(1)
    public void check_method_loadByUserName() {
        when(userEntityRepository.getUserEntityWithRoles(same("1"))).thenReturn(
                Optional.of(testUser)
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername("1");
        System.out.println(userDetails.getPassword());

        boolean matches = passwordEncoder.matches("1", userDetails.getPassword());
     assertTrue(matches);


    }

}
