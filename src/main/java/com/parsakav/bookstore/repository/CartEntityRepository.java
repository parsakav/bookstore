package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartEntityRepository extends JpaRepository<CartEntity, Integer> {
}