package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.dto.BookDTO;
import com.parsakav.bookstore.entity.BookEntity;

public interface BookDAO {

    BookEntity insert(BookEntity bookEntity);
}
