package com.custom.service.sms;

import com.custom.common.exception.AppBizException;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface SmsService {

     void sendMessage(String phone,String message);

    void  sendCode(String phone,String code) throws AppBizException;

    void sendCode(String phone,String msg,String code);


}
