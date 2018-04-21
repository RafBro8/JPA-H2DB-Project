package com.jpa.h2db.jpa.h2db.project.service;

import com.jpa.h2db.jpa.h2db.project.repository.SpringDataUserRepository;
import com.jpa.h2db.jpa.h2db.project.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SpringDataUserRepoCommandLineRunner implements CommandLineRunner {

    //org.slf4j.Logger helps log the new user saved to DB
    private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

    @Autowired
    private SpringDataUserRepository springDataUserRepository;


    @Override
    public void run(String... args) throws Exception {

        User user = new User("Roman", "Nickname");

        springDataUserRepository.save(user);//save user(Roman) to DB
        log.info("New User is created" + user);


        Optional<User> userWithIdOne = springDataUserRepository.findById(1L);
        log.info("User is retrieved" + userWithIdOne);

        List<User> users = springDataUserRepository.findAll();
        log.info("All Users" + users);

    }
}
//output in SpringBoot Console when Application is run: (Log) now 2 users logged (save and insert methods)
//2018-04-21 13:54:28.622  INFO 5726 --- [main] .j.h.p.s.UserDAOServiceCommandLineRunner : New User is createdUser{id=1, name='Roman', role='Nickname'}
//Hibernate: call next value for hibernate_sequence
//Hibernate: insert into user (name, role, id) values (?, ?, ?)
//2018-04-21 13:54:28.626  INFO 5726 --- [main] .j.h.p.s.UserDAOServiceCommandLineRunner : New User is createdUser{id=2, name='Raf', role='Boss'}