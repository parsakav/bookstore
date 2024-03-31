package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookEntityRepository extends JpaRepository<BookEntity, Integer> {
}