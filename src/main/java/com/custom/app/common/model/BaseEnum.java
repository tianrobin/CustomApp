/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.common.model;

/**
 * <p>枚举定义接口</p>
 * 规范要求：<p>所有枚举enum都需要implements该接口</p>
 *          <p>所有枚举都定义到该包下面，可以新建包进行分类</p>
 * @author wb-tianzd
 * @version $Id: BaseEnum.java, v 0.1 2013-3-18 下午03:19:45 wb-tianzd Exp $
 */
public interface BaseEnum {

    /**
     * <p>获取code</p>
     * <p>每个enum都会隐性实现该接口方法，无需子enum类手工编写</p>
     * @return  code
     */
    String name();

    /**
     * <p>获取枚举描述</p>
     * @return  code描述
     */
    String getDesc();
}
