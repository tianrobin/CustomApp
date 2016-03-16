package com.custom.dao.custom;

import com.custom.common.IOperations;
import com.custom.modle.User;

import java.util.List;

/**
 * Created by robin.tian on 16-3-10.
 */
public interface IUserDao extends IOperations<User> {


    User findByName(String userName);


    List<User> findUserLikeUserName(String userName);

}
