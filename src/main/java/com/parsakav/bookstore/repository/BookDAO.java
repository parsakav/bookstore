package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.BookEntity;

import java.util.List;

public interface BookDAO {

    BookEntity insert(BookEntity bookEntity);

    public List<BookEntity> getAllBooks();


}
