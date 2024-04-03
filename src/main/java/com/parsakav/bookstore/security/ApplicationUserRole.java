package com.parsakav.bookstore.security;

public enum ApplicationUserRole {

   ADMIN("ROLE_ADMIN"),USER("ROLE_USER");

   private String role;
    ApplicationUserRole(String role_user) {
        role=role_user;
    }

    public String getRole() {
        return role;
    }
}
