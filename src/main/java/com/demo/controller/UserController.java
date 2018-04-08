package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/4/8 15:32
 */
@Controller
public class UserController {

    @RequestMapping("hello")
    public String hello(HttpServletRequest request, Map map){
        map.put("a","a");
        return "index";
    }

}
