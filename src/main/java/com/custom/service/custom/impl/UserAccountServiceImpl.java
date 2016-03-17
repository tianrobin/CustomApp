package com.custom.service.custom.impl;

import com.custom.common.IOperations;
import com.custom.dao.custom.UserAccountDao;
import com.custom.modle.custom.UserAccount;
import com.custom.service.AbstractService;
import com.custom.service.custom.UserAccountService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by robin.tian on 16-3-17.
 */
@Service
public class UserAccountServiceImpl extends AbstractService<UserAccount> implements UserAccountService {

    @Inject
    private UserAccountDao userAccountDao;

    @Override
    protected IOperations<UserAccount> getDao() {
        return userAccountDao;
    }
}
