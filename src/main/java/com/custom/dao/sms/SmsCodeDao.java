package com.custom.dao.sms;

import com.custom.common.IOperations;
import com.custom.modle.sms.SmsCode;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface SmsCodeDao extends IOperations<SmsCode> {

    SmsCode getSmsCode(String phone);
}
