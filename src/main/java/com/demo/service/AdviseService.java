package com.demo.service;

import com.demo.mapper.AdviseMapper;
import com.demo.pojo.Advise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/7 22:32
 */
@Service
public class AdviseService {

    @Autowired
    private AdviseMapper adviseMapper;

    public int addAdvise(Advise advise){
        int insert = adviseMapper.insert(advise);
        return insert;
    }

    public int reply(Advise advise){
        int i = adviseMapper.updateByPrimaryKeySelective(advise);
        return i;
    }

    public List<Advise> listByUserId(int userId){
        List<Advise> list = adviseMapper.listByUserId(userId);
        return list;
    }

    public List<Advise> list(){
        List<Advise> list = adviseMapper.list();
        return list;
    }

    public Advise getById(int id){
        Advise advise = adviseMapper.selectByPrimaryKey(id);
        return advise;
    }

}
