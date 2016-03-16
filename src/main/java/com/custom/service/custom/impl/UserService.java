package com.custom.service.custom.impl;

import com.custom.common.IOperations;
import com.custom.dao.custom.IUserDao;
import com.custom.modle.User;
import com.custom.service.AbstractService;
import com.custom.service.custom.IUserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by robin.tian on 16-3-16.
 */
@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Inject
    private IUserDao userDao;

    public UserService() {
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
}
