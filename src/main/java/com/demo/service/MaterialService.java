package com.demo.service;

import com.demo.mapper.MaterialMapper;
import com.demo.pojo.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/11 22:20
 */
@Service
public class MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    public List<Material> list() {
        List<Material> list = materialMapper.list();
        return list;
    }

    public void add(Material material) {
        materialMapper.insert(material);
    }

    public void sub(int id, int num) {
        materialMapper.sub(id,num);
    }
}
