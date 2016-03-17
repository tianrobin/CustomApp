package com.custom.modle.custom;

import com.custom.common.BaseObject;
import com.custom.type.channel.OsTypeEnum;
import com.custom.type.custom.GenderEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by robin.tian on 16-3-10.
 */
@NamedQueries(value = {
        @NamedQuery(name = "getUserLikeUserName", query = "select  u from User u where u.userName like :userName")
})
@Entity
@Table(name = "p_user")
public class User extends BaseObject {
    private static final long serialVersionUID = -3644285261380382399L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 32, unique = true)
    private String userName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "nick_name", length = 32)
    private String nickName;

    @Column(name = "fristName", length = 32)
    private String fristName;


    @Column(name = "gender", length = 1)
    @Enumerated(value = EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "create_time")
    private Date createTime=new Date();

    @Column(name = "update_time")
    private Date updateTime =new Date();

    @Column(name = "openid")
    private String openid;

    @Column(name = "deviceid")
    private String deviceid;

    @Column(name = "ostype")
    @Enumerated(value = EnumType.STRING)
    private OsTypeEnum osType;

    @OneToOne(targetEntity = UserAccessToken.class, mappedBy = "user", cascade = CascadeType.ALL)
    private UserAccessToken token;


    /**
     * @FIXME UserCar 并不是用户必须的重要信息，没有必要查询用户信息的时候就把用户的车辆信息查出来，
     * 所以可以做一个一对多的单向关联即可，在多的一端进行关联维护
     */
//    @OneToMany(targetEntity = UserCar.class, fetch = FetchType.LAZY, mappedBy = "user")
//    private List<UserCar> userCars =new ArrayList<UserCar>();


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getFristName() {
        return fristName;
    }

    public User setFristName(String fristName) {
        this.fristName = fristName;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public User setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public User setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public User setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public User setDeviceid(String deviceid) {
        this.deviceid = deviceid;
        return this;
    }

    public OsTypeEnum getOsType() {
        return osType;
    }

    public User setOsType(OsTypeEnum osType) {
        this.osType = osType;
        return this;
    }

    public UserAccessToken getToken() {
        return token;
    }

    public User setToken(UserAccessToken token) {
        this.token = token;
        return this;
    }
}
