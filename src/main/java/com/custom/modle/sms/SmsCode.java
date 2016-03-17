package com.custom.modle.sms;

import com.custom.common.BaseObject;
import org.apache.commons.lang.time.DateUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by robin.tian on 16-3-17.
 */
@Entity
@Table(name = "p_sms_code")
public class SmsCode extends BaseObject {
    private static final long serialVersionUID = 3419793417549046217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "code")
    private String code;

    @Column(name = "expire_time")
    private Date expireTime = DateUtils.addDays(new Date(), 7);

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "update_time")
    private Date updateTime=new Date();

    @Column(name = "total_sum")
    private int totalSum=0;

    @Column(name = "tody_sum")
    private int todySum=0;

    public long getId() {
        return id;
    }

    public SmsCode setId(long id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SmsCode setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SmsCode setCode(String code) {
        this.code = code;
        return this;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public SmsCode setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SmsCode setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public SmsCode setTotalSum(int totalSum) {
        this.totalSum = totalSum;
        return this;
    }

    public int getTodySum() {
        return todySum;
    }

    public SmsCode setTodySum(int todySum) {
        this.todySum = todySum;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SmsCode setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
