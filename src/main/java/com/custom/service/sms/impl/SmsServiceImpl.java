package com.custom.service.sms.impl;

import com.custom.common.exception.AppBizException;
import com.custom.common.exception.AppErrCodeEnums;
import com.custom.common.exception.AppRTException;
import com.custom.core.SmsSenderFacade;
import com.custom.core.SmsSenderFactory;
import com.custom.dao.sms.SmsCodeDao;
import com.custom.dao.sms.SmsMessageDao;
import com.custom.modle.sms.SmsCode;
import com.custom.modle.sms.SmsMessage;
import com.custom.service.sms.SmsService;
import com.custom.type.SmsChannel;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/17.
 */
@Service
public class SmsServiceImpl implements SmsService {
    private Logger logger = LogManager.getLogger(SmsServiceImpl.class);

    private SmsSenderFacade facade=null;

    @Inject
    private SmsCodeDao smsCodeDao;

    @Inject
    private SmsMessageDao smsMessageDao;

    /**
     * 定时任务更新短信发送器
     */
    @Scheduled(fixedRate = 10*60*1000)
    public void getSmsSender(){
        //@TODO 从系统参数中获取配置的短信渠道
        facade = SmsSenderFactory.getSmsSender(SmsChannel.DEFAULT);
    }

    @Override
    public void sendMessage(String phone, String message) {
        logger.debug(">>> Send SMS Message Phone={},Message={}",phone,message);
        SmsMessage smsMessage = new SmsMessage().setSmsMessage(message).setPhone(phone);
        smsMessageDao.create(smsMessage);
        if(!facade.sms(phone,message)){
            logger.error(">>> SMS Message Sender Error");
        }

    }

    @Override
    public void sendCode(String phone, String code)  {
        SmsCode smsCode = smsCodeDao.getSmsCode(phone);
        if(null ==  smsCode){
            smsCode = new SmsCode().setPhone(phone).setTotalSum(1).setTodySum(1);
        }else {
            if(smsCode.getTodySum()>50|| smsCode.getTodySum()>1000){
                throw new AppRTException(AppErrCodeEnums.ERR_BIZ_SMS_CODE_SEND_NUM_TO_MUCH.name(),AppErrCodeEnums.ERR_BIZ_SMS_CODE_SEND_NUM_TO_MUCH.getDesc());
            }
            smsCode.setTotalSum(smsCode.getTotalSum() + 1);
            String today = DateUtils.format(new Date(), "MM-dd");
            String updateTime = DateUtils.format(smsCode.getUpdateTime(), "MM-dd");
            if (StringUtils.equals(today,updateTime)) {
                smsCode.setTotalSum(smsCode.getTotalSum() + 1);
            } else {
                smsCode.setTodySum(1);
            }
        }
        String message= "您本次操作的验证码是：" + code + "，请在输入前确认是您本人操作";
        //将短信验证码保存到数据库中
        smsCode.setCode(code);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1); // 一个小时候后过期
        smsCode.setExpireTime(calendar.getTime());
        smsCodeDao.create(smsCode);
        //将发送短信验证码的短息保存到数据库中
        SmsMessage smsMessage = new SmsMessage().setSmsMessage(message).setPhone(phone);
        smsMessageDao.create(smsMessage);
        //发送短信
        if(facade.sms(phone,message)){
            logger.error(">>> SMS Code Sender Error");
        }

    }

    @Override
    public void sendCode(String phone, String msg, String code) {

    }
}
