/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.common.exception.model;

import java.text.MessageFormat;

/**
 * 自定义运行时异常
 * @author wb-tianzd
 * @version $Id: AppRTException.java, v 0.1 2013-1-16 下午05:27:32 wb-tianzd Exp $
 */
public class AppRTException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = -3632018787987357654L;

    /**
     * 异常码
     */
    private String            code;

    /**
     * 异常描述参数
     */
    private String[]          args;

    /**
     * 文本消息
     */
    private String            textMessage;

    /**
     * 异常链构造器对象
     * @param cause 异常对象
     * @param code 本异常错误码
     * @param msg  本异常错误消息
     */
    public AppRTException(Throwable cause, String code, String msg) {
        super(code + ": " + msg, cause);
        this.code = code;
        this.textMessage = msg;
    }

    /**
     * 异常链构造器对象
     * @param cause 异常对象
     * @param code 本异常错误码
     * @param msg  本异常错误消息
     * @param args 现场信息：如外部订单号
     */
    public AppRTException(Throwable cause, String code, String msg, String... args) {
        super(code + ": " + formatMessage(msg, args), cause);
        this.code = code;
        this.args = args;
        this.textMessage = msg;
    }

    /**
     * 构造新异常类对象
     * @param code 本异常错误码
     * @param msg  本异常错误消息
     */
    public AppRTException(String code, String msg) {
        super(code + ": " + msg);
        this.code = code;
        this.textMessage = msg;
    }

    /**
     *  构造新异常类对象
     * @param code 错误码
     * @param msg  错误消息
     * @param args 现场信息：如外部订单号
     */
    public AppRTException(String code, String msg, String... args) {
        super(code + ": " + formatMessage(msg, args));
        this.code = code;
        this.args = args;
        this.textMessage = msg;
    }

    /**
     * 格式化msg私有方法
     * @param msg  错误消息
     * @param args 现场信息：如外部订单号
     * @return      格式化后错误信息的字符串
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
     * @param args  string数组
     * @return      对象数组
     */
    private static Object[] castStrArraysToObjectArrays(String[] args) {
        Object[] object = new Object[args.length];
        for (int i = 0; i < args.length; ++i) {
            object[i] = args[i];
        }
        return object;
    }

    /**
     * 得到错误码
     * @return code 错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * 得到现场信息值数组：如 外部订单号
     *
     * @return 得到现场信息值数组
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * 得到提示消息模板
     *
     * @return  提示消息模板
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * Setter method for property <tt>args</tt>.
     *
     * @param args value to be assigned to property args
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Setter method for property <tt>textMessage</tt>.
     *
     * @param textMessage value to be assigned to property textMessage
     */
    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return formatMessage(this.textMessage, this.args);
    }

}
