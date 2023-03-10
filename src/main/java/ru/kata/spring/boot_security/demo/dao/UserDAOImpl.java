package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
//без typed запроса

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    @Override
    public User showById(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void update(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }


    @Override
    public void delete(Long id) {
        entityManager.remove(showById(id));
    }


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public User findByUsername(String emailReq) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1")
                .setParameter(1, emailReq)
                .getSingleResult();
    }


}