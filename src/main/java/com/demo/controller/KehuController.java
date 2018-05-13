package com.demo.controller;

import com.demo.dto.DishesDTO;
import com.demo.pojo.Dishes;
import com.demo.pojo.User;
import com.demo.service.DishesService;
import com.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/11 22:42
 */
@Controller
public class KehuController {

    @Autowired
    private DishesService dishesService;
    @Autowired
    private OrdersService OrdersService;

    //菜单列表
    @RequestMapping("fuwu_dishes_list")
    public String list(Map map){
        List<DishesDTO> list = dishesService.list();
        map.put("list",list);
        return "fuwu_dishes_list";
    }

    //推荐菜单列表  前10个
    @RequestMapping("fuwu_dishes_tuijian")
    public String tuijian(Map map){
        List<DishesDTO> list = dishesService.listTuijian();
        map.put("list",list);
        //return "fuwu_dishes_tuijian";
        return "fuwu_dishes_list";
    }

    //点菜
    @RequestMapping("fuwu_dishes_add")
    public String addDishes(int id, HttpSession session){
        User user = (User) session.getAttribute("user");
        OrdersService.addDishes(id,user.getId());
        return "forward:/fuwu_dishes_list";
    }

    //已点菜单列表
    @RequestMapping("fuwu_orders_list")
    public String yidianList(HttpSession session,Map map){
        User user = (User) session.getAttribute("user");
        List<DishesDTO> list = dishesService.getYidianDishes(user.getId());
        map.put("list",list);
        return "fuwu_orders_list";
    }



}
