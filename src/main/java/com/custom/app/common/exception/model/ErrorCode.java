/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.common.exception.model;

/**
 * <p>错误码接口</p>
 * <p>所有错误码enum都需要implements该接口</p>
 * @author wb-tianzd
 * @version $Id: ErrorCode.java, v 0.1 2013-1-16 下午05:16:40 wb-tianzd Exp $
 */
public interface ErrorCode {
    /**
     * <p>获取错误码</p>
     * <p>每个enum都会隐性实现该接口方法，无需子enum类手工编写</p>
     * @return  错误码
     */
    String name();

    /**
     * <p>获取错误码描述</p>
     * @return  错误码描述
     */
    String getDesc();
}
