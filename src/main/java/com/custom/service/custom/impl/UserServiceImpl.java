package com.custom.service.custom.impl;

import com.custom.common.IOperations;
import com.custom.dao.custom.UserDao;
import com.custom.modle.custom.User;
import com.custom.modle.custom.UserAccessToken;
import com.custom.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by robin.tian on 16-3-16.
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements com.custom.service.custom.UserService {

    @Inject
    private UserDao userDao;

    public UserServiceImpl() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return userDao;
    }

    @Override
    public User findByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public List<User> findUserLikeUserName(String userName) {
        return userDao.findUserLikeUserName(userName);
    }

    @Override
    public User login(String userName, String code) {
        return null;
    }

    @Override
    public User addUser(String userName,boolean sendSms) {
        User user =new User().setUserName(userName);
        user.setToken(new UserAccessToken().setUser(user));
        userDao.create(user);
        return user;
    }
}
