package com.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> list();

    UserInfo getUserInfoByUserId(@Param("userId") int userId);

    //话费充值
    int updateFare(@Param("userId") Integer id, @Param("fare") Integer fare);

    //流量充值
    int updateFlow(@Param("userId") Integer id,@Param("flow") Integer flow);

    //积分兑换
    int buyPointGift(@Param("userId") int userId,@Param("point") String point);
}