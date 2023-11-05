package com.example.model;

public class UserManager {
    private static User currentUser;

    public static void setUser(User user) {
        currentUser = user;
    }

    public static User getUser() {
        return currentUser;
    }

    public static void logout(){
        currentUser = null;
    }

}
