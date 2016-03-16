package com.custom.dao.custom.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.dao.custom.IUserDao;
import com.custom.modle.custom.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by robin.tian on 16-3-11.
 */
@Repository
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {
    Logger logger = LogManager.getLogger(UserDao.class);

    public UserDao() {
        setClazz(User.class);
    }

    @Override
    public User findByName(String userName) {
        logger.debug(">>> Find User By userName is {}", userName);
        String jpql = "select u from User as  u where u.userName=:userName";
        Query query = getEm().createQuery(jpql);
        query.setParameter("userName", userName);
        List<User> userList = query.getResultList();
        if(CollectionUtils.isNotEmpty(userList)){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> findUserLikeUserName(String userName) {
        logger.debug(">>> feind User Like userName is {}",userName);
        Query query = getEm().createNamedQuery("getUserLikeUserName");
        query.setParameter("userName", "%"+userName+"%");
        return query.getResultList();
    }
}
