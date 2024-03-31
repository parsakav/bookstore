package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.CartCartitemEntity;
import com.parsakav.bookstore.entity.CartCartitemEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartCartitemEntityRepository extends JpaRepository<CartCartitemEntity, CartCartitemEntityPK> {
}