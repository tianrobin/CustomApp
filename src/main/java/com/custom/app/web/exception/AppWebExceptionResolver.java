/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.web.exception;

import com.custom.app.common.exception.model.AppBizException;
import com.custom.app.common.exception.model.AppErrCodeEnums;
import com.custom.app.common.exception.model.AppRTException;
import com.custom.app.common.logUtil.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理
 *
 * @author robin.tian
 * @version $Id: AppWebExceptionResolver.java, v 0.1 2014年9月18日 下午2:10:29 robin.tian Exp $
 */
public class AppWebExceptionResolver implements HandlerExceptionResolver {
    /**
     * logger
     */
    Logger logger = LoggerFactory.getLogger(AppWebExceptionResolver.class);

    /**
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object obj, Exception exception) {
        /********************************************************
         * 自定义异常处理
         ********************************************************/
        String errorCode = AppErrCodeEnums.ERR_SYS_UNKNOWN.name();
        String errorMsg = AppErrCodeEnums.ERR_SYS_UNKNOWN.getDesc();
        if (exception instanceof AppBizException) {
            AppBizException bizE = (AppBizException) exception;
            LoggerUtil.error(logger, bizE, "业务异常{0}", exception.getMessage());
        } else if (exception instanceof AppRTException) {
            AppRTException rtE = (AppRTException) exception;
            LoggerUtil.error(logger, rtE, "系统异常{0}", exception.getMessage());
        } else {
            AppRTException rtE = new AppRTException(AppErrCodeEnums.ERR_SYS_UNKNOWN.name(),
                    AppErrCodeEnums.ERR_SYS_UNKNOWN.getDesc());
            LoggerUtil.error(logger, rtE, "未定义异常{0}", exception.getMessage());
        }

        /*********************************************************
         * 初始化ModelAndView
         ********************************************************/
        ModelAndView modelandview = new ModelAndView();
        request.setAttribute("ERROR_CODE", errorCode);
        request.setAttribute("ERROR_MSG", errorMsg);
        modelandview.setViewName("forward:/error.htm");
        return modelandview;
    }
}
