package com.custom.dao.impl;

import com.custom.dao.UserDao;
import com.custom.modle.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by robin.tian on 16-3-11.
 */
@Repository
public class UserDaoImpl implements UserDao {



     @PersistenceContext
     private EntityManager em;


    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        em.persist(user);
        em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class,id);
    }

    @Override
    public User login(String phone, String password) {
        return null;
    }

}
