package com.custom.modle.custom;

import com.custom.common.BaseObject;

import javax.persistence.*;

/**
 * Created by robin.tian on 16-3-10.
 */
@Entity
@Table(name = "p_user_car")
public class UserCar extends BaseObject {

    private static final long serialVersionUID = -3544087223977755021L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uid")
    private User user;

    @Column(name = "car_no")
    private String carNo;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_color")
    private String carColor;


    public Long getId() {
        return id;
    }

    public UserCar setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserCar setUser(User user) {
        this.user = user;
        return this;
    }

    public String getCarNo() {
        return carNo;
    }

    public UserCar setCarNo(String carNo) {
        this.carNo = carNo;
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public UserCar setCarName(String carName) {
        this.carName = carName;
        return this;
    }

    public String getCarColor() {
        return carColor;
    }

    public UserCar setCarColor(String carColor) {
        this.carColor = carColor;
        return this;
    }
}
