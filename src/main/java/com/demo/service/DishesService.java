package com.demo.service;

import com.demo.dto.DishesDTO;
import com.demo.mapper.DishesMapper;
import com.demo.mapper.MaterialMapper;
import com.demo.mapper.OrdersMapper;
import com.demo.pojo.Dishes;
import com.demo.pojo.Material;
import com.demo.pojo.Orders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/11 22:20
 */
@Service
public class DishesService {

    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    public void addDishes(Dishes dishes) {
        dishesMapper.insert(dishes);
    }

    public void delDeshes(int id) {
        dishesMapper.deleteByPrimaryKey(id);
    }

    //菜品list   管理员
    public List<DishesDTO> list() {
        List<Dishes> dishes = dishesMapper.list();
        List<DishesDTO> list  = new ArrayList<>();
        for(Dishes dish:dishes){
            DishesDTO dishesDTO = new DishesDTO();
            BeanUtils.copyProperties(dish,dishesDTO);
            Material material = materialMapper.selectByPrimaryKey(dish.getMid());
            dishesDTO.setmName(material.getName());
            dishesDTO.setMnum(material.getNum());
            list.add(dishesDTO);
        }
        return list;
    }
    //推荐
    public List<DishesDTO> listTuijian() {
        List<Dishes> dishes = dishesMapper.listTuijian();
        List<DishesDTO> list  = new ArrayList<>();
        for(Dishes dish:dishes){
            DishesDTO dishesDTO = new DishesDTO();
            BeanUtils.copyProperties(dish,dishesDTO);
            Material material = materialMapper.selectByPrimaryKey(dish.getMid());
            dishesDTO.setmName(material.getName());
            list.add(dishesDTO);
        }
        return list;
    }

    public List<DishesDTO> getYidianDishes(Integer userId) {
        List<DishesDTO> list = new ArrayList<>();
        List<Orders> orders = ordersMapper.selectByUserId(userId);
        for(Orders order:orders){
            DishesDTO dishesDTO = new DishesDTO();
            Dishes dishes = dishesMapper.selectByPrimaryKey(order.getDishid());
            BeanUtils.copyProperties(dishes,dishesDTO);
            dishesDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(order.getCtime()));
            list.add(dishesDTO);
        }
        return list;
    }
}
