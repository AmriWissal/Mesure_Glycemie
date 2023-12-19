package com.example.mesure_glycmie.Model;

public class User {

    private String userName;
    private String password;
    public User(String userName, String password)
    {
        this.userName=userName;
        this.password=password;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getPassword()
    {
        return password;
    }
}

