/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.common.logUtil;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * 日志格式化打印工具类
 * @author robin.tian
 * @version $Id: LoggerUtils.java, v 0.1 2014年9月15日 下午4:56:55 robin.tian Exp $
 */
public class LoggerUtil {

    /**
     * <p>DEBUG 级别日志输出</p>
     * @param logger
     * @param pattern
     * @param arguments
     */
    public static void debug(Logger logger, String pattern, Object... arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug(MessageFormat.format(pattern, arguments));
        }
    }

    /**
     * <p>DEBUG 级别日志输出，不带有业务参数</p>
     * @param logger
     * @param pattern
     */
    public static void debug(Logger logger,String pattern){
        if(logger.isDebugEnabled()){
            logger.debug(pattern);
        }
    }

    /**
     * <p>DEBUG 级别的日志输出，带有右侧堆栈信息</p>
     * @param logger
     * @param throwable
     * @param pattern
     * @param arguments
     */
    public static void debug(Logger logger, Throwable throwable, String pattern,
                             Object... arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug(MessageFormat.format(pattern, arguments), throwable);
        }
    }

    /**
     * <p>INFO 级别日志输出</p>
     * @param logger
     * @param pattern
     * @param arguments
     */
    public static void info(Logger logger, String pattern, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(pattern, arguments));
        }
    }

    /**
     * <p>INFO 级别日志输出，不带有业务信息</p>
     * @param logger
     * @param pattern
     */
    public static void info(Logger logger, String pattern) {
        if (logger.isInfoEnabled()) {
            logger.info(pattern);
        }
    }
    /**
     * <p>INOF 级别日志输出，带有异常堆栈信息</p>
     * @param logger
     * @param throwable
     * @param pattern
     * @param arguments
     */
    public static void info(Logger logger, Throwable throwable, String pattern, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(MessageFormat.format(pattern, arguments), throwable);
        }
    }

    /**
     * <p>WARN 级别日志输出</p>
     * @param logger
     * @param pattern
     * @param arguments
     */
    public static void warn(Logger logger, String pattern, Object... arguments) {
        logger.warn(MessageFormat.format(pattern, arguments));
    }

    /**
     * <p>WARN 级别日志输出，不带有业务信息</p>
     * @param logger
     * @param pattern
     */
    public static void warn(Logger logger, String pattern) {
        logger.warn(pattern);
    }
    /**
     * <p>WARN 级别日志输出,带有异常堆栈信息</p>
     * @param logger
     * @param throwable
     * @param pattern
     * @param arguments
     */
    public static void warn(Logger logger, Throwable throwable, String pattern, Object... arguments) {
        logger.warn(MessageFormat.format(pattern, arguments), throwable);
    }

    /**
     * <p>ERROR 级别日志输出</p>
     * @param logger
     * @param pattern
     * @param arguments
     */
    public static void error(Logger logger, String pattern, Object... arguments) {
        logger.error(MessageFormat.format(pattern, arguments));
    }

    /**
     * <p>ERROR 级别日志输出，不带有业务信息</p>
     * @param logger
     * @param pattern
     */
    public static void error(Logger logger, String pattern) {
        logger.error(pattern);
    }

    /**
     * <p>ERROR 级别日志输出，带有异常堆栈信息</p>
     * @param logger
     * @param throwable
     * @param pattern
     * @param arguments
     */
    public static void error(Logger logger, Throwable throwable, String pattern,
                             Object... arguments) {
        logger.error(MessageFormat.format(pattern, arguments), throwable);
    }

}
