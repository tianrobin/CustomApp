package com.custom.dao;

import com.custom.AbstractTest;
import com.custom.common.Money;
import com.custom.modle.custom.User;
import com.custom.modle.custom.UserAccount;
import com.custom.service.custom.UserService;
import com.custom.service.custom.UserAccountService;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by robin.tian on 16-3-17.
 */
public class UserAccountServiceTest extends AbstractTest {

    @Inject
    private UserAccountService userAccountService;

    @Inject
    private UserService userService;

    @Test
    public void test_creatUserAccount(){
        UserAccount userAccount = new UserAccount();
        userAccount.setObtainAmount(new Money(1000));
        User user = userService.findByName("13701937520");
        userAccount.setUser(user);
        userAccountService.create(userAccount);

    }

    @Test
    public void test_findOne(){
        UserAccount userAccount = userAccountService.findOne(1l);
        System.out.println(userAccount);
    }
}
