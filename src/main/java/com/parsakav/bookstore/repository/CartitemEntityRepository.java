package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.CartitemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartitemEntityRepository extends JpaRepository<CartitemEntity, Integer> {
}