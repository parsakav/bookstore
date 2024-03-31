package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.UserRoleEntity;
import com.parsakav.bookstore.entity.UserRoleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity, UserRoleEntityPK> {
}