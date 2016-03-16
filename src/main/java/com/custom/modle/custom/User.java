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
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "openid")
    private String openid;

    @Column(name = "deviceid")
    private String deviceid;

    @Column(name = "ostype")
    @Enumerated(value = EnumType.STRING)
    private OsTypeEnum osType;

    @OneToOne(targetEntity = UserAccessToken.class,mappedBy = "user",cascade = CascadeType.ALL)
    private UserAccessToken token;


    /**
     *
     * @FIXME UserCar 并不是用户必须的重要信息，没有必要查询用户信息的时候就把用户的车辆信息查出来，
     * 所以可以做一个一对多的单向关联即可，在多的一端进行关联维护
     */
//    @OneToMany(targetEntity = UserCar.class, fetch = FetchType.LAZY, mappedBy = "user")
//    private List<UserCar> userCars =new ArrayList<UserCar>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public OsTypeEnum getOsType() {
        return osType;
    }

    public void setOsType(OsTypeEnum osType) {
        this.osType = osType;
    }

//    public List<UserCar> getUserCars() {
//        return userCars;
//    }
//
//    public void setUserCars(List<UserCar> userCars) {
//        this.userCars = userCars;
//    }

    public UserAccessToken getToken() {
        return token;
    }

    public void setToken(UserAccessToken token) {
        this.token = token;
    }
}
