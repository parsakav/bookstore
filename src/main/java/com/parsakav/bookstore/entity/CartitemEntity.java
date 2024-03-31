package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cartitem", schema = "bookstore", catalog = "")
public class CartitemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cartitem_id")
    private int cartitemId;
    @Basic
    @Column(name = "book_title")
    private String bookTitle;
    @Basic
    @Column(name = "book_price")
    private int bookPrice;
    @Basic
    @Column(name = "number")
    private int number;
    @Basic
    @Column(name = "bookimg")
    private String bookimg;
    @OneToMany(mappedBy = "cartitemByCartitemId")
    private Collection<CartCartitemEntity> cartCartitemsByCartitemId;

    public int getCartitemId() {
        return cartitemId;
    }

    public void setCartitemId(int cartitemId) {
        this.cartitemId = cartitemId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartitemEntity that = (CartitemEntity) o;
        return cartitemId == that.cartitemId && bookPrice == that.bookPrice && number == that.number && Objects.equals(bookTitle, that.bookTitle) && Objects.equals(bookimg, that.bookimg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartitemId, bookTitle, bookPrice, number, bookimg);
    }

    public Collection<CartCartitemEntity> getCartCartitemsByCartitemId() {
        return cartCartitemsByCartitemId;
    }

    public void setCartCartitemsByCartitemId(Collection<CartCartitemEntity> cartCartitemsByCartitemId) {
        this.cartCartitemsByCartitemId = cartCartitemsByCartitemId;
    }
}
