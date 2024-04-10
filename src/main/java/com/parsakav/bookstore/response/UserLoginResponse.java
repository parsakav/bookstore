package com.parsakav.bookstore.response;

import com.parsakav.bookstore.entity.UserRoleEntity;

import java.util.Collection;

public class UserLoginResponse {

    private String email;
    private String password;

    private String fullname;

    private String addrsss;


    private String phonenumber;

    private int postalcode;

    private Collection<UserRoleEntity> userRoleEntities;

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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public Collection<UserRoleEntity> getUserRoleEntities() {
        return userRoleEntities;
    }

    public void setUserRoleEntities(Collection<UserRoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }
}
