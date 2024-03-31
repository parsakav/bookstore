package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
}