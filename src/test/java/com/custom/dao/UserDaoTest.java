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
import java.util.List;

/**
 * Created by robin.tian on 16-3-11.
 */
public class UserDaoTest extends AbstractTest {

    @Inject
    private IUserService userService;


    @Test
    public void test_saveOrUpdate(){
        for(int i=0;i<10;i++){
        User user = new User();
        user.setCreateTime(new Date());
        user.setDeviceid(i+"Deviceid");
        user.setFristName(i+"FristName");
        user.setGender(GenderEnum.F);
        user.setNickName(i+"NickName");
        user.setOpenid(i+"openid");
        user.setOsType(OsTypeEnum.ANDROID);
        user.setPassword(i+"Password");
        user.setUpdateTime(new Date());
        user.setUserName(i+"UserName");
        userService.create(user);}
    }

    @Test
    public void test_getUserById(){
        User user =userService.findOne(15l);
        System.out.println(user);
    }

    @Test
    public void test_GetUserbyUserName(){
        User user =userService.findByName("1UserName");
        System.out.println(user);
    }

    @Test
    public void test_findUserLikeUserName(){
        List<User> userList = userService.findUserLikeUserName("%Name%");
        System.out.println(userList);
    }
}
