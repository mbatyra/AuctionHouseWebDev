package com.example.AuctionHouse.user;

public enum Role {
    ROLE_admin("ROLE_admin"),
    ROLE_user("ROLE_user");

    String value;

    Role(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
