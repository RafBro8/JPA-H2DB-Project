package com.jpa.h2db.jpa.h2db.project.service;

import com.jpa.h2db.jpa.h2db.project.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


//Save user to DB using UserDAOService


@Repository        //interacts with the DB
@Transactional     //means each Method in this Class will be involved in DB Transaction
public class UserDAOService {     //User DAO Service - Data Access Object - helps access data for the DB

    //Persistence Context
    // Entity Manager is an Interface to Persistence Context
    // entityManager.persist("John") - this saves to DB and also starts tracking it in the Persistence Context
    //"John" is now inside the Persistence Context
    @PersistenceContext
    private EntityManager entityManager;        //help manage User Entity, help save users and retrieve users from the DB

    public long insert(User user) {              //User user is Entity being saved to DB when passed as Param here

        //Open DB Transaction
        entityManager.persist(user);            //make an instance managed and persisted
        //Close DB Transaction

        return user.getId();
    }
}


//H2 URL - http://localhost:8080/h2-console