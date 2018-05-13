package com.demo.service;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/4/8 23:21
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user){
        User login = userMapper.login(user);
        return login;
    }

    public int register(User user){
        int i = userMapper.insert(user);
        return i;
    }

    public List<User> listUser(User user){
        List<User> list = userMapper.listUser(user);
        return list;
    }

    public int delUser(int id){
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    public int addUser(User user){
        int insert = userMapper.insert(user);
        return insert;
    }

}
