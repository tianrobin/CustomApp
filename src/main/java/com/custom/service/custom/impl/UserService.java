package com.custom.service.custom.impl;

import com.custom.common.IOperations;
import com.custom.dao.custom.IUserDao;
import com.custom.modle.User;
import com.custom.service.AbstractService;
import com.custom.service.custom.IUserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by robin.tian on 16-3-16.
 */
@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Inject
    private IUserDao iUserDao;

    public UserService() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return iUserDao;
    }
}
