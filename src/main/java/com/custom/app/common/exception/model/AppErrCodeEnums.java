/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.common.exception.model;

/**
 * 系统错误码定义枚举
 * @author wb-tianzd
 * @version $Id: AppErrCodeEnums.java, v 0.1 2013-1-16 下午05:13:09 wb-tianzd Exp $
 */
public enum AppErrCodeEnums implements ErrorCode {

    //    ##错误消息维度划分
    //    #1级          ERR
    //    #====================== 系统异常 ======================
    //    #2级系统异常  ERR_SYS
    //    #3级系统异常  ERR_SYS_UNKNOWN  未知系统错误
    //    #3级系统异常  ERR_SYS_NET      未知网络错误

    //
    //    #====================== 业务异常 ======================
    //    #2级业务异常  ERR_BIZ
    /** 系统异常 */
    SYS_ERROR("系统异常"),

    /**  未知系统错误     */
    ERR_SYS_UNKNOWN("未知系统错误"),

    /** 未知网络错误   */
    ERR_SYS_NET("未知网络错误"),

    /** 没有访问权限   */
    ERR_SYS_NOT_ACCESS("没有访问权限"),

    /** 请登入系统  */
    ERR_SYS_USER_NOT_LOGIN("请登入系统"),

    /** 非法的URL请求  */
    ERR_SYS_ILLEGAL_URL("非法的URL请求"),

    ;

    /** 错误码描述 */
    private String desc;

    /**
     * 初始化对象
     * @param desc 错误描述
     */
    AppErrCodeEnums(String desc) {
        this.desc = desc;
    }

    /**
     * 获取错误码相应描述
     * @see com.custom.app.common.exception.model.ErrorCode.app.common.exception.model.ErrorCode#getDesc()
     */
    public String getDesc() {
        return desc;
    }

}
