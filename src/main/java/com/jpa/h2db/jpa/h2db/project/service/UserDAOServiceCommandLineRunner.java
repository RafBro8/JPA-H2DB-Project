package com.jpa.h2db.jpa.h2db.project.service;

//Command Line Runner executes when Spring Context launches,
// when Application first starts, the code in the Command Line Runner gets executed

import com.jpa.h2db.jpa.h2db.project.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component      //managed by Spring
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {


//org.slf4j.Logger helps log the new user saved to DB
    private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    @Autowired    //dependency
    private UserDAOService userDAOService;         //helps save user to DB

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Raf", "Boss");

        long insert = userDAOService.insert(user);//save user(Raf) to DB

        log.info("New User is created" + user);
//output in SpringBoot Console when Application is run:
//2018-04-19 22:15:42.592  INFO 4940 --- [main] .j.h.p.s.UserDAOServiceCommandLineRunner : New User is createdUser{id=1, name='Raf', role='Boss'}
        //available through Command Line Runner

    }
}
