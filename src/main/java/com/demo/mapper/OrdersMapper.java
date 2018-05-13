package com.demo.mapper;

import com.demo.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    //根据用户id查询订单列表
    List<Orders> selectByUserId(@Param("userId") Integer userId);

    List<Orders> list();
}