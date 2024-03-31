package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cart_cartitem", schema = "bookstore", catalog = "")
@IdClass(CartCartitemEntityPK.class)
public class CartCartitemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cartitem_id")
    private int cartitemId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;
    @ManyToOne
    @JoinColumn(name = "cartitem_id", referencedColumnName = "cartitem_id", nullable = false)
    private CartitemEntity cartitemByCartitemId;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    private CartEntity cartByCartId;

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
        CartCartitemEntity that = (CartCartitemEntity) o;
        return cartitemId == that.cartitemId && cartId == that.cartId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartitemId, cartId);
    }

    public CartitemEntity getCartitemByCartitemId() {
        return cartitemByCartitemId;
    }

    public void setCartitemByCartitemId(CartitemEntity cartitemByCartitemId) {
        this.cartitemByCartitemId = cartitemByCartitemId;
    }

    public CartEntity getCartByCartId() {
        return cartByCartId;
    }

    public void setCartByCartId(CartEntity cartByCartId) {
        this.cartByCartId = cartByCartId;
    }
}
