package com.parsakav.bookstore.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "bookstore", catalog = "")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Basic
    @Column(name = "email", unique = true)
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "address")
    private String address;


    @Column(name = "phonenumber", unique = true)
    private String phoneNumber;
    @Basic
    @Column(name = "postalcode", unique = true)
    private int postalcode;

    @OneToMany(mappedBy = "user")
    private Collection<CartEntity> carts;


    @ManyToMany()
    @JoinTable(name = "USER_ROLE_",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> userRoleEntities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return phoneNumber == that.phoneNumber && postalcode == that.postalcode && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullname, that.fullname) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, fullname, address, phoneNumber, postalcode);
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<CartEntity> getCarts() {
        return carts;
    }

    public void setCarts(Collection<CartEntity> carts) {
        this.carts = carts;
    }

    public Collection<RoleEntity> getUserRoleEntities() {
        return userRoleEntities;
    }

    public void setUserRoleEntities(Collection<RoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }
}
