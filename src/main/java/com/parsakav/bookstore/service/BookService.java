package com.parsakav.bookstore.service;

import com.parsakav.bookstore.entity.BookEntity;

import java.util.List;

public interface BookService {
    public BookEntity addBook(BookEntity bookEntity);

    public List<BookEntity> getAllBooks();

}
