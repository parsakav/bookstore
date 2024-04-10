package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {


    @Query(value = "from UserEntity ue  join fetch  ue.userRoleEntities where ue.phoneNumber=:phoneNumber")
    public Optional<UserEntity> getUserEntityWithRoles(String phoneNumber);
}