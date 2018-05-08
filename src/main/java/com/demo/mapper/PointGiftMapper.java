package com.demo.mapper;

import com.demo.pojo.PointGift;

import java.util.List;

public interface PointGiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointGift record);

    int insertSelective(PointGift record);

    PointGift selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointGift record);

    int updateByPrimaryKey(PointGift record);

    List<PointGift> listPointGifts();
}