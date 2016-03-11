package com.custom.modle;

import javax.persistence.*;

/**
 * Created by robin.tian on 16-3-10.
 */
@Entity(name = "p_user_car")

public class UserCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @PrimaryKeyJoinColumn(name = "uid")
    private User user;

    @Column(name="car_no")
    private String carNo;

    @Column(name="car_name")
    private String carName;

    @Column(name = "car_color")
    private String carColor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
