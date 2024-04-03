package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "bookstore", catalog = "")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;
    @Basic
    @Column(name = "user_phone")
    private String userPhone;
    @Basic
    @Column(name = "time")
    private Date time;
    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartCartitemEntity> cartCartitemsByCartId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return cartId == that.cartId && userPhone == that.userPhone && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, userPhone, time);
    }

    public Collection<CartCartitemEntity> getCartCartitemsByCartId() {
        return cartCartitemsByCartId;
    }

    public void setCartCartitemsByCartId(Collection<CartCartitemEntity> cartCartitemsByCartId) {
        this.cartCartitemsByCartId = cartCartitemsByCartId;
    }
}
