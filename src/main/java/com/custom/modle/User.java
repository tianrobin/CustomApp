package com.custom.modle;

import com.custom.common.BaseObject;
import com.custom.type.channel.OsTypeEnum;
import com.custom.type.custom.GenderEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;

/**
 * Created by robin.tian on 16-3-10.
 */
@Entity(name = "p_user")
public class User extends BaseObject {
    private static final long serialVersionUID = -3644285261380382399L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 32)
    private String userName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "nick_name", length = 32)
    private String nickName;

    @Column(name = "fristName", length = 32)
    private String fristName;


    @Column(name = "gender",length =1)
    private GenderEnum gender;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Column(name = "openid")
    private String openid;

    @Column(name = "deviceid")
    private String deviceid;

    @Column(name="ostype")
    private OsTypeEnum osType;


    @OneToMany(targetEntity = UserCar.class,fetch = FetchType.EAGER,mappedBy = "user")
    private List<UserCar> userCars;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public List<UserCar> getUserCars() {
        return userCars;
    }

    public void setUserCars(List<UserCar> userCars) {
        this.userCars = userCars;
    }
}
