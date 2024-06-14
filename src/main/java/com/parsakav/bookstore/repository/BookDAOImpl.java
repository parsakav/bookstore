
package com.parsakav.bookstore.repository;

import com.parsakav.bookstore.entity.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public BookEntity insert(BookEntity bookEntity) {
        entityManager.persist(bookEntity);
        return bookEntity;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return entityManager.createQuery("SELECT b FROM BookEntity b", BookEntity.class).getResultList();
    }
}


