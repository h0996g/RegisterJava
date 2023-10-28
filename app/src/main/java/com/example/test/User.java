package com.example.test;

import java.io.Serializable;

public class User implements Serializable {
    String nom;
    String prenom;
    String email;
    String phone;


    public User(String nom, String prenom, String email, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;



    }

    public User(){}
}
