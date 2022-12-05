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

        User user = new User("user@gmail.com","Анна", "Дронова","user",
                "$2a$12$4z1NcYOQq.8DxTUQ43XZ6OTpppa88XmTwZOLh/VukCl5a8y3Q6mWm",
                Collections.singletonList(role_user));

        User admin = new User("admin@gmail.com","Tom", "Jerry","admin",
                "$2a$12$bKIKWE2BjIX9fbQ9yKAfAuKXmVzcOAvzrABADzuGx8i0RQNuZ2ZlC",
                Collections.singletonList(role_admin));


        entityManager.persist(admin);
        entityManager.persist(user);

    }
}
