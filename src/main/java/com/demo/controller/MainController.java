package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.pojo.Person;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/9 10:47
 */
@Controller
public class MainController {

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public Object list(HttpServletRequest request, HttpServletResponse response, Person person) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = person.getName();
        Integer age = person.getAge();
        String city = person.getCity();
        String desc = person.getDesc();
        String phone = person.getPhone();

        String path = getClass().getClassLoader().getResource("data.json").getPath();
        String s = FileUtils.readFileToString(new File(path), "UTF-8");
        List<Person> list = (List) JSONObject.parseArray(s,Person.class);
        Set<Person> set = new HashSet<>();
        for(Person temp : list){
            if(temp.getName().contains(name)&&temp.getCity().contains(city)&&temp.getDesc().contains(desc)
                    &&temp.getPhone().contains(phone)&&(age==null?true:age == temp.getAge())){
                set.add(temp);
            }
        }
        if(set.size()==0){
            return "not found data!";
        }
        return set;
    }

}
