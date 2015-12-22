/**
* autumnframework org Inc.
* Copyright (c) 2014-2014 All Rights Reserved.
*/
package com.custom.app.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class TestJsonController {

    @RequestMapping(value = "/test.json")
    public void testJson(ModelMap modelMap) {
        Map<String, String> aa = new HashMap<String, String>();
        aa.put("name", "robin.tian");
        aa.put("age", "16");
        modelMap.addAttribute("user", aa);
    }

}
