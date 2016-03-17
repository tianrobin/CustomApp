package com.custom.modle.custom;

import com.custom.common.BaseObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/3/16.
 */
@Entity
@Table(name = "p_user_access_token")
public class UserAccessToken extends BaseObject {

    private static final long serialVersionUID = -3797046332680496067L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "uid")
    private User user;

    @Column(name = "token")
    private String token = StringUtils.replace(UUID.randomUUID().toString(),"-","").toUpperCase();

    @Column(name = "expire")
    private int expire=7*60*60;

    @Column(name = "create_time")
    private Date createTime=new Date();

    @Column(name = "update_time")
    private Date updateTime=new Date();

    @Column(name = "expireTime")
    private Date expireTime= DateUtils.addDays(new Date(),7);

    public Long getId() {
        return id;
    }

    public UserAccessToken setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserAccessToken setUser(User user) {
        this.user = user;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserAccessToken setToken(String token) {
        this.token = token;
        return this;
    }

    public int getExpire() {
        return expire;
    }

    public UserAccessToken setExpire(int expire) {
        this.expire = expire;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserAccessToken setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserAccessToken setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public UserAccessToken setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }
}
