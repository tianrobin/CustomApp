/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.custom.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author wb-tianzd
 * @version $Id: HomeContrColler.java, v 0.1 2013-1-11 обнГ04:38:02 wb-tianzd Exp $
 */
@Controller
@RequestMapping("/index.*")
public class IndexController {

    @RequestMapping
    public String toIndex(ModelMap modelMap) {
        return "index";
    }

}
