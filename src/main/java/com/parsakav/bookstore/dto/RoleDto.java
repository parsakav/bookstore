package com.parsakav.bookstore.dto;

import com.parsakav.bookstore.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RoleDto {

    @Getter
    @Setter
    public static class Output {
        private String roleName;

        public static Output mapping(RoleEntity roleEntity) {
            Output user = new Output();
            BeanUtils.copyProperties(roleEntity, user);
            return user;
        }

        public static List<Output> mapping(List<RoleEntity> bookEntities) {
            return bookEntities.stream().map(Output::mapping).collect(Collectors.toList());
        }


    }
}
