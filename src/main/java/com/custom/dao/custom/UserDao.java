package com.custom.dao.custom;

import com.custom.common.IOperations;
import com.custom.modle.custom.User;

import java.util.List;

/**
 * Created by robin.tian on 16-3-10.
 */
public interface UserDao extends IOperations<User> {


    User findByName(String userName);


    List<User> findUserLikeUserName(String userName);


//    User register(String userName);



}
