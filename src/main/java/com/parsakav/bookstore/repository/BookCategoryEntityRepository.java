package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.BookCategoryEntity;
import com.parsakav.bookstore.entity.BookCategoryEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookCategoryEntityRepository extends JpaRepository<BookCategoryEntity, BookCategoryEntityPK> {
}