package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "bookstore", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "isbn")
    private String isbn;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "bookimg")
    private String bookimg;
    @Basic
    @Column(name = "tag")
    private String tag;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "stock")
    private int stock;
    @OneToMany(mappedBy = "bookByBookId")
    private Collection<BookCategoryEntity> bookCategoriesByBookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookId == that.bookId && price == that.price && stock == that.stock && Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(isbn, that.isbn) && Objects.equals(description, that.description) && Objects.equals(bookimg, that.bookimg) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, title, isbn, description, bookimg, tag, price, stock);
    }

    public Collection<BookCategoryEntity> getBookCategoriesByBookId() {
        return bookCategoriesByBookId;
    }

    public void setBookCategoriesByBookId(Collection<BookCategoryEntity> bookCategoriesByBookId) {
        this.bookCategoriesByBookId = bookCategoriesByBookId;
    }
}
