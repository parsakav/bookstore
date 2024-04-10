package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.time.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "bookstore", catalog = "")
public class CartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;


    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "", nullable = false)

    private UserEntity user;
    @Basic
    @Column(name = "time")

    private LocalDateTime time;
    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartCartitemEntity> cartCartitemsByCartId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }




    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return cartId == that.cartId && user.equals(that.user) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, user.getId(), time);
    }

    public Collection<CartCartitemEntity> getCartCartitemsByCartId() {
        return cartCartitemsByCartId;
    }

    public void setCartCartitemsByCartId(Collection<CartCartitemEntity> cartCartitemsByCartId) {
        this.cartCartitemsByCartId = cartCartitemsByCartId;
    }
}
