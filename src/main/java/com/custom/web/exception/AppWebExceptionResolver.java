package com.custom.web.exception;

import com.custom.common.exception.AppBizException;
import com.custom.common.exception.AppErrCodeEnums;
import com.custom.common.exception.AppRTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2015/12/24.
 */
public class AppWebExceptionResolver implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(AppWebExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj, Exception e) {
        String errorCode = AppErrCodeEnums.ERR_SYS_UNKNOWN.name();
        String errorMsg = AppErrCodeEnums.ERR_SYS_UNKNOWN.getDesc();
        if (e instanceof AppBizException) {
            AppBizException bizE = (AppBizException) e;
            errorCode = bizE.getCode();
            errorMsg = bizE.getMessage();
            logger.error("业务异常：{}", errorMsg, bizE);
        } else if (e instanceof AppRTException) {
            AppRTException rtE = (AppRTException) e;
            errorCode = rtE.getCode();
            errorMsg = rtE.getMessage();
            logger.error("系统异常：{}", errorMsg, rtE);
        } else if (e instanceof IllegalArgumentException) {
            AppBizException bizE = new AppBizException(e, AppErrCodeEnums.ERR_SYS_ILLEGAL_ARGUMENT.name(), e.getMessage());
            errorCode = bizE.getCode();
            errorMsg = bizE.getMessage();
            logger.error("请求参数异常：{}", errorMsg, bizE);
        } else {
            AppRTException rtE = new AppRTException(e, AppErrCodeEnums.ERR_SYS_UNKNOWN.name(), e.getMessage());
            errorCode = rtE.getCode();
            errorMsg = rtE.getMessage();
            logger.error("未知系统异常：{}", errorMsg, rtE);
        }
        ModelAndView modelAndView = new ModelAndView();



        modelAndView.setViewName("");
        return modelAndView;
    }
}
