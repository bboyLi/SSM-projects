package com.demo.controller;

import com.demo.pojo.Business;
import com.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/2 22:49
 */
@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("user_business_list")
    public String list(HttpServletRequest request, Map map){
        List<Business> list = businessService.list();
        map.put("list",list);
        return "user_business_list";
    }

    @RequestMapping("add_business")
    public String add(Business business){
        businessService.addBusiness(business);
        return "forward:/user_business_list";
    }

    @RequestMapping("del_business")
    public String delBu(int id){
        businessService.delBusiness(id);
        return "forward:/user_business_list";
    }

    @RequestMapping("fuwu_business_list")
    public String fuwuBusiness(Map map){
        List<Business> list = businessService.list();
        map.put("list",list);
        return "/fuwu_business_list";
    }

}
