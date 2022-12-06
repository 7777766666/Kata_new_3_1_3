package ru.kata.spring.boot_security.demo.configs;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entytis.Role;
import ru.kata.spring.boot_security.demo.entytis.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;

@Component
@Transactional
public class UsersForStartTable implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role_admin = new Role("ROLE_ADMIN");
        Role role_user = new Role("ROLE_USER");

        User user1 = new User("Анна", "Дронова","user@gmail.com","user",
                "$2a$12$4z1NcYOQq.8DxTUQ43XZ6OTpppa88XmTwZOLh/VukCl5a8y3Q6mWm",
                Collections.singletonList(role_user));

        User admin1 = new User("Tom", "Jerry","admin@Gmail.com", "admin",
                "$2a$12$bKIKWE2BjIX9fbQ9yKAfAuKXmVzcOAvzrABADzuGx8i0RQNuZ2ZlC",
                Collections.singletonList(role_admin));
        User admin2 = new User( "Ivan", "Petrov", "admin@gmail.com", "admin",
                "$2a$12$e2kPm6WGFJXq.0.aOFcYw.2g2Rd4NUNeDvZ5lwEaZEexjHUGukI7a");
        User user2 = new User("Bob", "Ivanovich", "bob@gmail.com", "user",
                "$2a$12$/Lsd2el1B0V7kuMXO8iLxeRaBom6KI97oc.qHW81/nZVH5ua2I6Hm");


        entityManager.persist(admin1);
        entityManager.persist(admin2);
        entityManager.persist(user1);
        entityManager.persist(user2);

    }
}
