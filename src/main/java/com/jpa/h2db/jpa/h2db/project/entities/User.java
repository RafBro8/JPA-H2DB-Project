package com.jpa.h2db.jpa.h2db.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//Store User in DB Table User

@Entity                  //persisted to the DB
public class User {

    @Id                //id is the Primary Key (@Id)
    @GeneratedValue    //generate Primary Key
    private long id;

    private String name;
    private String role;

    protected User() {

    }

    public User(String name, String role) {

        this.name = name;
        this.role = role;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
