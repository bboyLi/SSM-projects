package com.demo.service;

import com.demo.dto.AmountDTO;
import com.demo.dto.DishesCountDTO;
import com.demo.dto.DishesDTO;
import com.demo.mapper.DishesMapper;
import com.demo.mapper.MaterialMapper;
import com.demo.mapper.OrdersMapper;
import com.demo.pojo.Dishes;
import com.demo.pojo.Material;
import com.demo.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/11 22:19
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private MaterialMapper materialMapper;

    public void addDishes(Integer dishesId, Integer userId) {
        Orders orders = new Orders();
        orders.setCtime(new Date());
        orders.setDishid(dishesId);
        orders.setUserid(userId);
        //订单添加
        ordersMapper.insert(orders);
        //菜品减1
        Dishes dishes = dishesMapper.selectByPrimaryKey(dishesId);
        dishes.setNum(dishes.getNum()+1); //已点次数
        dishesMapper.updateByPrimaryKeySelective(dishes);
        //原料减1
        Material material = materialMapper.selectByPrimaryKey(dishes.getMid());
        //material.setPrice(material.getPrice().subtract(material.getPrice().divide(BigDecimal.valueOf(material.getNum()))));
        material.setNum(material.getNum()-1);
        materialMapper.updateByPrimaryKeySelective(material);
    }

    /**
     * 收银统计
     * @return
     */
    public List<AmountDTO> shouyin() {
        List<AmountDTO> list = new ArrayList<>();
        List<Orders> orders = ordersMapper.list();
        Set<String> dates = new HashSet<>();
        for(Orders order :orders){
           dates.add(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime()));
        }
        for(String date:dates){
            AmountDTO amountDTO = new AmountDTO();
            amountDTO.setIncome(new BigDecimal(0));
            amountDTO.setPay(new BigDecimal(0));
            amountDTO.setDate(date);
            for(Orders order :orders){
                if(date.equals(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime()))){
                    Dishes dishes = dishesMapper.selectByPrimaryKey(order.getDishid());
                    Material material = materialMapper.selectByPrimaryKey(dishes.getMid());
                    amountDTO.setIncome(amountDTO.getIncome().add(dishes.getPrice()));
                    amountDTO.setPay(amountDTO.getPay().add(material.getPrice()));
                }
            }
            list.add(amountDTO);
        }
        return list;
    }

    /**
     * 菜品统计
     * @return
     */
    public List<DishesCountDTO> dishesTongji() {
        List<DishesCountDTO> list = new ArrayList<>();
        List<Orders> orders = ordersMapper.list();
        Set<String> dates = new HashSet<>();
        for(Orders order :orders){
            dates.add(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime()));
        }
        for(String date:dates){
            Set<Integer> dishesIds = new HashSet<>();
            for(Orders order :orders){
                if(date.equals(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime()))){
                    dishesIds.add(order.getDishid());
                }
            }
            for(Integer dishesId:dishesIds){
                Dishes dishes = dishesMapper.selectByPrimaryKey(dishesId);
                DishesCountDTO dishesCountDTO = new DishesCountDTO();
                dishesCountDTO.setDate(date);
                dishesCountDTO.setCount(0);
                dishesCountDTO.setName(dishes.getName());
                for(Orders order :orders){
                    if(date.equals(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime())) && order.getDishid().equals(dishesId)){
                        dishesCountDTO.setCount(dishesCountDTO.getCount()+1);
                    }
                }
                list.add(dishesCountDTO);
            }
        }
        return list;
    }
}
