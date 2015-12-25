package com.custom.common.exception;

import java.text.MessageFormat;

/**
 * Created by admin on 2015/12/24.
 */
public class AppRTException extends RuntimeException {

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常描述参数
     */
    private String[] args;
    /**
     * 异常文本消息
     */
    private String textMessage;


    public AppRTException(String code, String msg) {
        super(code + ":" + msg);
        this.code = code;
        this.textMessage = msg;
    }

    public AppRTException(String code, String message, String... args) {
        super(code + ":" + formatMessage(message, args));
        this.code = code;
        this.args = args;
        this.textMessage = message;
    }

    public AppRTException(Throwable cause, String code, String message) {
        super(code + ":" + message, cause);
        this.code = code;
        this.textMessage = message;
    }

    public AppRTException(Throwable cause, String code, String message, String... args) {
        super(code + ":" + formatMessage(message, args), cause);
        this.code = code;
        this.args = args;
        this.textMessage = message;
    }

    /**
     * 格式化msg私有方法
     *
     * @param msg  错误消息
     * @param args 现场信息：如外部订单号
     * @return 格式化后的字符串
     */
    private static String formatMessage(String msg, String[] args) {
        if (args == null) {
            return msg;
        }
        Object[] object = castStrArraysToObjectArrays(args);
        return MessageFormat.format(msg, object);
    }

    /**
     * 将string数组转为对象数组
     *
     * @param args string数组
     * @return 对象数组
     */
    private static Object[] castStrArraysToObjectArrays(String[] args) {
        Object[] object = new Object[args.length];
        for (int i = 0; i < args.length; ++i) {
            object[i] = args[i];
        }
        return object;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public String getMessage() {
        return formatMessage(this.textMessage, this.args);
    }
}

