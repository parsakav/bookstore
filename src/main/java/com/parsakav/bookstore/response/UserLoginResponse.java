package com.parsakav.bookstore.response;

import com.parsakav.bookstore.entity.RoleEntity;

import java.util.Collection;

public class UserLoginResponse {

    private String email;
    private String password;

    private String fullname;

    private String addrsss;


    private String phoneNumber;

    private int postalcode;

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

    public String getAddrsss() {
        return addrsss;
    }

    public void setAddrsss(String addrsss) {
        this.addrsss = addrsss;
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

    public Collection<RoleEntity> getUserRoleEntities() {
        return userRoleEntities;
    }

    public void setUserRoleEntities(Collection<RoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }
}
