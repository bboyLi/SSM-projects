package com.demo.mapper;

import com.demo.pojo.Dishes;

import java.util.List;

public interface DishesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dishes record);

    int insertSelective(Dishes record);

    Dishes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dishes record);

    int updateByPrimaryKey(Dishes record);

    List<Dishes> list();

    List<Dishes> listTuijian();

}