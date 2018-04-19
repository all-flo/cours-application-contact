package com.example.florence.cours_list;

import com.orm.SugarRecord;

import java.io.Serializable;

public class Contact extends SugarRecord implements Serializable{

    String nom;
    String prenom;
    String telephone;

    public Contact (){}

    public Contact (String n, String p, String t){
        nom=n;
        prenom=p;
        telephone=t;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {

        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
