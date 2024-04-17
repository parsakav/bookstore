package com.parsakav.bookstore.dto;


import com.parsakav.bookstore.entity.RoleEntity;
import com.parsakav.bookstore.entity.UserEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDto implements Serializable {

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class LoginIn {

        private String phoneNumber;
        private String password;
        public static UserEntity mapping(LoginIn userLogin){
            UserEntity user = new UserEntity();
            BeanUtils.copyProperties(userLogin,user);
            return user;
        }

    }

    @Getter
    @Setter
    public static class Input {


        private String email;
        private String password;

        private String fullname;

        private String address;


        private String phoneNumber;

        private int postalcode;
        public static UserEntity mapping(Input userEntity){
            UserEntity user = new UserEntity();
            BeanUtils.copyProperties(userEntity,user);
            return user;
        }
        public static List<UserEntity> mapping(List<Input> userEntities){
            return userEntities.stream().map(Input::mapping).collect(Collectors.toList());
        }
    }
    @Getter
    @Setter
    public static class Output {
        private String email;
        private String fullname;

        private String address;


        private String phoneNumber;

        private int postalcode;
        private List<RoleDto.Output> roles;

        public static Output mapping(UserEntity userEntity){
            Output user = new Output();
            BeanUtils.copyProperties(userEntity,user);
         user.roles=RoleDto.Output.mapping(userEntity.getUserRoleEntities().stream().collect(Collectors.toList()) );
            return user;
        }
        public static List<Output> mapping(List<UserEntity> bookEntities){
            return bookEntities.stream().map(Output::mapping).collect(Collectors.toList());
        }
    }
}
