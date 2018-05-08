package com.demo.service;

import com.demo.mapper.BusinessMapper;
import com.demo.pojo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/2 22:50
 */
@Service
public class BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    public List<Business> list(){
        List<Business> list = businessMapper.listBusiness();
        return list;
    }

    public void addBusiness(Business business) {
        businessMapper.insert(business);
    }

    public void delBusiness(int id) {
        businessMapper.deleteByPrimaryKey(id);
    }
}
