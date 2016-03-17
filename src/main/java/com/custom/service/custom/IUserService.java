package com.custom.service.custom;

import com.custom.common.IOperations;
import com.custom.modle.custom.User;

import java.util.List;

/**
 * Created by robin.tian on 16-3-16.
 */
public interface IUserService extends IOperations<User> {


    User findByName(String userName);

    List<User> findUserLikeUserName(String userName);

    User login(String userName,String code);

    User addUser(String userName,boolean sendSms);


}
