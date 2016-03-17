package com.custom.dao.sms.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.dao.sms.SmsMessageDao;
import com.custom.modle.sms.SmsMessage;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Repository
public class SmsMessageDaoImpl extends AbstractHibernateDao<SmsMessage> implements SmsMessageDao {
    public SmsMessageDaoImpl() {
        setClazz(SmsMessage.class);
    }
}
