package com.parsakav.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CartCartitemEntityPK implements Serializable {
    @Column(name = "cartitem_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartitemId;
    @Column(name = "cart_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    public int getCartitemId() {
        return cartitemId;
    }

    public void setCartitemId(int cartitemId) {
        this.cartitemId = cartitemId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartCartitemEntityPK that = (CartCartitemEntityPK) o;
        return cartitemId == that.cartitemId && cartId == that.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartitemId, cartId);
    }
}
