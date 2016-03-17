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

    @Column(name = "phone")
    private String phone;

    @Column(name = "code")
    private String code;

    @Column(name = "expire_time")
    private Date expireTime = DateUtils.addDays(new Date(), 7);

    @Column(name = "create_time")
    private Date createTime = new Date();


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
}
