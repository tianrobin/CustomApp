package com.custom.dao;

import com.custom.AbstractTest;
import com.custom.dao.custom.IUserDao;
import com.custom.modle.User;
import com.custom.service.custom.IUserService;
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
    private IUserService userService;


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
        userService.create(user);
    }

    @Test
    public void test_getUserById(){
        User user =userService.findOne(1l);
        System.out.println(user);
    }
}
