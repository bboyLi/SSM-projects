package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public String hello(HttpServletRequest request, Map map){
        map.put("a","a");
        return "index";
    }

    @RequestMapping("/user_login")
    public String login(HttpServletRequest request, Map map, User user){
        HttpSession session = request.getSession();
        User login = userService.login(user);
        if(login!=null){
            session.setAttribute("user",login);
            if(user.getRole().equals("2")){     //1.系统管理员
                return "forward:/admin_dishes_list";
            }
            if(user.getRole().equals("1")){     //2.服务员
                return "forward:/fuwu_dishes_list";
            }
            else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    @RequestMapping("/user_loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    @RequestMapping("/user_register")
    public String register(HttpServletRequest request,User user){
        int register = userService.register(user);
        return "login";
    }

    @RequestMapping("/user_listUser")
    public String listUser(HttpServletRequest request,User user,Map map){
        List<User> list = userService.listUser(new User());
        map.put("list",list);
        return "user_list";
    }

    @RequestMapping("/user_delUser")
    public String delUser(HttpServletRequest request,int id){
        int i = userService.delUser(id);
        return "forward:/user_listUser";
    }

    @RequestMapping("/user_addUser")
    public String addUser(HttpServletRequest request,User user){
        userService.addUser(user);
        return "forward:/user_listUser";
    }

}
