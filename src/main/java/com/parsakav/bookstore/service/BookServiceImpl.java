package com.parsakav.bookstore.service;

import com.parsakav.bookstore.entity.BookEntity;
import com.parsakav.bookstore.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDAO bookDAO;

    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        return bookDAO.insert(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}