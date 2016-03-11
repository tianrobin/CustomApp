package com.custom.dao;

import com.custom.AbstractTest;
import com.custom.dao.impl.UserDaoImpl;
import com.custom.modle.User;
import com.custom.type.channel.OsTypeEnum;
import com.custom.type.custom.GenderEnum;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by robin.tian on 16-3-11.
 */
public class UserDaoTest extends AbstractTest {

    @Inject
    private UserDao userDao;


    @Test
    public void test_saveOrUpdate(){
        User user = new User();
        user.setCreateTime(new Date());
        user.setDeviceid("Deviceid");
        user.setFristName("FristName");
        user.setGender(GenderEnum.F);
        user.setNickName("NickName");
        user.setOpenid("openid");
        user.setOsType(OsTypeEnum.ANDROID);
        user.setPassword("Password");
        user.setUpdateTime(new Date());
        user.setUserName("UserName");
        userDao.saveOrUpdate(user);
    }

    @Test
    public void test_getUserById(){
        User user =userDao.getUserById(1l);
        System.out.println(user);
    }
}
