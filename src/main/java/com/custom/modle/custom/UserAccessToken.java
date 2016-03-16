package com.custom.modle.custom;

import com.custom.common.BaseObject;

import javax.persistence.*;
import java.util.Date;

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
    private String token;

    @Column(name = "expire")
    private int expire;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "expireTime")
    private Date expireTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
