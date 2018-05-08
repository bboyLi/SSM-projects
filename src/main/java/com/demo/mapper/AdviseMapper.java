package com.demo.mapper;

import com.demo.pojo.Advise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdviseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advise record);

    int insertSelective(Advise record);

    Advise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);

    List<Advise> listByUserId(@Param("userId") int userId);

    List<Advise> list();
}