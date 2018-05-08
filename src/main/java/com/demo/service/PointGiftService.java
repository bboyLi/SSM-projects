package com.demo.service;

import com.demo.mapper.PointGiftMapper;
import com.demo.mapper.UserInfoMapper;
import com.demo.pojo.PointGift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO:Responsibility description of this class.
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/6 23:02
 */
@Service
public class PointGiftService {
    @Autowired
    private PointGiftMapper pointGiftMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<PointGift> list(){
        List<PointGift> list = pointGiftMapper.listPointGifts();
        return list;
    }

    public int addPointGift(PointGift pointGift){
        int i = pointGiftMapper.insert(pointGift);
        return i;
    }

    public int buyPointGift(int userId,int giftId){
        PointGift pointGift = pointGiftMapper.selectByPrimaryKey(giftId);
        int i =  userInfoMapper.buyPointGift(userId,pointGift.getPoint());
        return i;
    }

}
