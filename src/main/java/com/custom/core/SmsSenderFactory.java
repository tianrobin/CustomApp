package com.custom.core;

import com.custom.common.exception.AppErrCodeEnums;
import com.custom.common.exception.AppRTException;
import com.custom.type.SmsChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/17.
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SmsSenderFactory {
    private static Logger logger = LogManager.getLogger(SmsSenderFactory.class);

    private static Map<SmsChannel, SmsSenderFacade> SENDERMAP = new HashMap<SmsChannel, SmsSenderFacade>();

    @PostConstruct
    public void initSenderMap() {
        //@TODO 初始化短信发送器Map
    }

    @PreDestroy
    public void cleanSenderMap() {
        SENDERMAP.clear();
    }

    public static SmsSenderFacade getSmsSender(SmsChannel smsChannel) {
        logger.info("get SmsSender by Channel {}", smsChannel);
        SmsSenderFacade smsSenderFacade = SENDERMAP.get(smsChannel);
        if (null == smsSenderFacade) {
            throw new AppRTException(AppErrCodeEnums.SYS_ERROR.name(),
                    AppErrCodeEnums.SYS_ERROR.getDesc());
        }
        return smsSenderFacade;
    }

}
