/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.web.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 统一异常导航页面
 */
@Controller
public class Error {
    /**
     * <p>异常页面导航</p>
     * @param modelMap
     * @param request
     */
    @RequestMapping(value = "/error.htm")
    public void renderError(ModelMap modelMap, HttpServletRequest request) {
        initModelMap(modelMap, request);
    }

    /**
     * <p>初始化ModelMap</p>
     * @param modelMap
     * @param request
     */
    private void initModelMap(ModelMap modelMap, HttpServletRequest request) {
        String errorCode = request.getParameter("ERROR_CODE");
        modelMap.addAttribute("ERROR_CODE", errorCode);
    }
}
