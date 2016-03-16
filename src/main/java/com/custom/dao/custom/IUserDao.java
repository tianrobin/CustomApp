package com.custom.dao.custom;

import com.custom.common.IOperations;
import com.custom.modle.User;

/**
 * Created by robin.tian on 16-3-10.
 */
public interface IUserDao extends IOperations<User> {


    User findByName(String userName);

}
