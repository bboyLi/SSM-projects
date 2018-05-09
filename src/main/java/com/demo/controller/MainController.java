package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/9 10:47
 */
@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public Object list(String name){
        return null;
    }

}
