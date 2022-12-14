package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entytis.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    public UserDaoImpl() {
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = entityManager.createQuery("SELECT u FROM User u where u.username =:username", User.class);
        query.setParameter("username", username);
        Optional<User> user = Optional.ofNullable((User)query.getResultList().get(0));

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Where is user? He is epsent");
        }

        return user.get();
    }

    @Override
    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
