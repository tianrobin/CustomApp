package com.custom.modle.custom;

import com.custom.common.BaseObject;
import com.custom.common.Money;
import com.custom.common.convert.MoneyConvert;
import com.custom.type.common.ValidTypeEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by robin.tian on 16-3-17.
 */
@Entity
@Table(name = "p_user_account")
public class UserAccount extends BaseObject {
    private static final long serialVersionUID = -4358134578674857863L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", unique = true, nullable = false)
    private User user;

    @Column(name = "obtain_amount")
    @Convert(converter = MoneyConvert.class)
    private Money obtainAmount = new Money(0);

    @Column(name = "deduct_amount")
    @Convert(converter = MoneyConvert.class)
    private Money deductAmount = new Money(0);

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "update_time")
    private Date updateTime = new Date();


    @Column(name = "is_valid")
    @Enumerated(value = EnumType.STRING)
    private ValidTypeEnum isValid =ValidTypeEnum.VALID;

    public Long getId() {
        return id;
    }

    public UserAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserAccount setUser(User user) {
        this.user = user;
        return this;
    }

    public Money getObtainAmount() {
        return obtainAmount;
    }

    public UserAccount setObtainAmount(Money obtainAmount) {
        this.obtainAmount = obtainAmount;
        return this;
    }

    public Money getDeductAmount() {
        return deductAmount;
    }

    public UserAccount setDeductAmount(Money deductAmount) {
        this.deductAmount = deductAmount;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserAccount setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public ValidTypeEnum getIsValid() {
        return isValid;
    }

    public UserAccount setIsValid(ValidTypeEnum isValid) {
        this.isValid = isValid;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserAccount setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
