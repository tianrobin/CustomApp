package com.custom.dao.custom.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.dao.custom.IUserDao;
import com.custom.modle.User;
import org.springframework.stereotype.Repository;

/**
 * Created by robin.tian on 16-3-11.
 */
@Repository
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {

    public UserDao() {
        setClazz(User.class);
    }

    @Override
    public User findByName(String userName) {
        return getEm().find(getClazz(), userName);
    }
}
