package com.custom.modle.sms;

import com.custom.common.BaseObject;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by robin.tian on 16-3-17.
 */
@Entity
@Table(name = "p_sms_message")
public class SmsMessage extends BaseObject {
    private static final long serialVersionUID = 2359816595018775920L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id ;

    @Column(name = "phone")
    private String phone;


    @Column(name = "sms_message")
    private String smsMessage;

    @Column(name = "create_time")
    private Date createTime=new Date();

    public long getId() {
        return id;
    }

    public SmsMessage setId(long id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SmsMessage setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public SmsMessage setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SmsMessage setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
