package com.custom.dao;

import com.custom.AbstractTest;
import com.custom.modle.custom.User;
import com.custom.modle.custom.UserAccessToken;
import com.custom.service.custom.UserService;
import com.custom.type.channel.OsTypeEnum;
import com.custom.type.custom.GenderEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by robin.tian on 16-3-11.
 */
public class UserDaoTest extends AbstractTest {

    @Inject
    private UserService userService;

    @Test
    public void test_saveOrUpdate() {
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
        UserAccessToken userAccessToken = new UserAccessToken();
        userAccessToken.setToken(StringUtils.replace(UUID.randomUUID().toString(), "-", "").toUpperCase());
        userAccessToken.setCreateTime(new Date());
        userAccessToken.setUpdateTime(new Date());
        userAccessToken.setExpireTime(DateUtils.addDays(new Date(), 7));
        userAccessToken.setExpire(24 * 60 * 60 * 7);
        userAccessToken.setUser(user);
        user.setToken(userAccessToken);
        userService.create(user);

    }

    @Test
    public void test_getUserById() {
        User user = userService.findOne(15l);
        System.out.println(user);
    }

    @Test
    public void test_GetUserbyUserName() {
        User user = userService.findByName("1UserName");
        System.out.println(user);
    }

    @Test
    public void test_findUserLikeUserName() {
        List<User> userList = userService.findUserLikeUserName("%Name%");
        System.out.println(userList);
    }

    @Test
    public void test_addUser() {
        User user = userService.addUser("13701937520", Boolean.FALSE);
        System.out.println(user);
    }
}
