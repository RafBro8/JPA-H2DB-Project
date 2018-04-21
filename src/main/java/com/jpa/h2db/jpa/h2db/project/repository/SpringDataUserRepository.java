package com.jpa.h2db.jpa.h2db.project.repository;

import com.jpa.h2db.jpa.h2db.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    //<User> is the entity we want to manage, <Long> is the Primary Key of User

}

//SPRING DATA - create simple Repository Interface with small method, then Spring Data JPA provides the implementation
//Save user to DB using SpringDataUserRepository


//H2 URL - http://localhost:8080/h2-console