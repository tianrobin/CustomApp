package com.custom.dao;

import com.custom.modle.User;

/**
 * Created by robin.tian on 16-3-10.
 */
public interface UserDao {


    void saveOrUpdate(User user);

    User getUserById(Long id);

    User login(String phone,String password);
}
