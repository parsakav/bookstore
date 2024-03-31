package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {
}