package com.custom.dao.sms.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.dao.sms.SmsCodeDao;
import com.custom.modle.sms.SmsCode;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
@Repository
public class SmsCodeDaoImpl extends AbstractHibernateDao<SmsCode> implements SmsCodeDao {

    public SmsCodeDaoImpl() {
        setClazz(SmsCode.class);
    }

    @Override
    public SmsCode getSmsCode(String phone) {
        Query query = getEm().createQuery("select sd from SmsCode as sd where sd.phone=:phone");
        query.setParameter("phone",phone);
        List<SmsCode> smsCodeList = query.getResultList();
        if(CollectionUtils.isNotEmpty(smsCodeList)){
            smsCodeList.get(0);
        }
        return null;
    }
}
