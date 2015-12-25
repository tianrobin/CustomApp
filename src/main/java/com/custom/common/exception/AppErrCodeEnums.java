package com.custom.common.exception;

/**
 * Created by admin on 2015/12/24.
 */
public enum AppErrCodeEnums implements Errorcode {


    SYS_ERROR("系统异常"),

    ERR_SYS_UNKNOWN("未知异常"),

    ERR_SYS_NET("未知网络异常"),

    ERR_SYS_NOT_ACCESS("没有访问权限"),

    ERR_SYS_ILLEGAL_ARGUMENT("非法的请求参数"),

    ;


    private String desc;

    AppErrCodeEnums(String desc) {
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
