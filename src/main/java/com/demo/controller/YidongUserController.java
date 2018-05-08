package com.demo.controller;

import com.demo.pojo.*;
import com.demo.service.BusinessService;
import com.demo.service.PointGiftService;
import com.demo.service.UserService;
import com.demo.util.HttpUtil;
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
 * @since 2018/5/4 9:42
 */
@Controller
public class YidongUserController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private UserService userService;
    @Autowired
    private PointGiftService pointGiftService;

    //归属地查询
    @RequestMapping("/yidong_area")
    public String phoneArea(HttpServletRequest request,String phone,Map map){
        if(phone == null){
            User user = (User) request.getSession().getAttribute("user");
            UserInfo userInfo = userService.getUserInfo(user.getId());
            phone = userInfo.getPhone();
        }
        PhoneArea area = HttpUtil.getPhoneAreaByTel(phone);
        map.put("area",area);
        return "/yidong_phoneArea";
    }
    //热门业务查询
    @RequestMapping("/yidong_business_list")
    public String yidongBu(Map map){
        List<Business> list = businessService.list();
        map.put("list",list);
        return "yidong_business_list";
    }
    //积分活动
    @RequestMapping("/yidong_jifen")
    public String jifen(HttpServletRequest request,Map map){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfo(user.getId());
        List<PointGift> list = pointGiftService.list();
        map.put("list",list);
        map.put("userInfo",userInfo);
        return "yidong_jifen";
    }
    //话费服务
    @RequestMapping("/yidong_fare")
    public String fare(HttpServletRequest request,String phone,Integer fare,Map map){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfo(user.getId());
        if(phone!=null && fare!=null){
            //话费充值
            int i = userService.addFare(user.getId(),fare);
            userInfo = userService.getUserInfo(user.getId());
        }
        map.put("userInfo",userInfo);
        return "yidong_fare";
    }

    //用户资料
    @RequestMapping("/yidong_userInfo")
    public String getUserInfo(HttpServletRequest request,Map map){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfo(user.getId());
        map.put("userInfo",userInfo);
        return "yidong_userInfo";
    }

    //用户流量管理
    @RequestMapping("/yidong_flow")
    public String flow(HttpServletRequest request,String phone,Integer flow,Map map){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfo(user.getId());
        if(phone!=null && flow!=null){
            //话费充值
            int i = userService.addFlow(user.getId(),flow);
            userInfo = userService.getUserInfo(user.getId());
        }
        map.put("userInfo",userInfo);
        return "yidong_flow";
    }

    //积分购买
    @RequestMapping("/yidong_buyGift")
    public String buyGift(int id,HttpServletRequest request){
        //积分购买
        User user = (User) request.getSession().getAttribute("user");
        pointGiftService.buyPointGift(user.getId(),id);
        return "forward:/yidong_jifen";
    }


}
