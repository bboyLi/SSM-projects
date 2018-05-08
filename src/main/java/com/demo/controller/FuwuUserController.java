package com.demo.controller;

import com.demo.pojo.User;
import com.demo.pojo.UserInfo;
import com.demo.service.UserService;
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
 * @since 2018/5/2 23:19
 */
@Controller
public class FuwuUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/fuwu_user_list")
    public String list(HttpServletRequest request, Map map){
        List<UserInfo> list = userService.listUserInfo();
        map.put("list",list);
        return "fuwu_user_list";
    }

    @RequestMapping("/addFuwuUser")
    public String add(UserInfo userInfo,String username){
        User user = new User();
        user.setPassword("123456");
        user.setRole("3");
        user.setUsername(username);
        userService.addUser(user);
        userInfo.setUserid(user.getId());
        userInfo.setFlow(0);
        userService.addUserInfo(userInfo);
        return "forward:/fuwu_user_list";
    }

    @RequestMapping("/delFuwuUser")
    public String del(int id,int userId){
        userService.delUser(userId);
        userService.delUserInfo(id);
        return "forward:/fuwu_user_list";
    }


}
