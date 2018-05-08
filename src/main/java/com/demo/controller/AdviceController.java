package com.demo.controller;

import com.demo.pojo.Advise;
import com.demo.pojo.User;
import com.demo.service.AdviseService;
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
 * @since 2018/5/7 22:40
 */
@Controller
public class AdviceController {

    @Autowired
    private AdviseService adviseService;

    //管理员
    @RequestMapping("user_advise_list")
    public String list(Map map){
        List<Advise> list = adviseService.list();
        map.put("list",list);
        return "user_advise_list";
    }

    //管理员回复
    @RequestMapping("user_advise_reply")
    public String reply(String content,int id){
        Advise advise = adviseService.getById(id);
        advise.setReplay(content);
        adviseService.reply(advise);
        return "forward:/user_advise_list";
    }

    @RequestMapping("yidong_advise_list")
    public String yidongList(HttpServletRequest request,Map map){
        User user = (User) request.getSession().getAttribute("user");
        List<Advise> list = adviseService.listByUserId(user.getId());
        map.put("list",list);
        return "yidong_advise_list";
    }

    @RequestMapping("yidong_add_advise")
    public String addAdvise(Advise advise,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        advise.setUserid(user.getId());
        adviseService.addAdvise(advise);
        return "forward:/yidong_advise_list";
    }


}
