package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserMapper  extends BaseMapper<User>{
    /**
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<User> selectByPage(IPage<User> page , @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    int  insertPrimaryInfoByOpenId(String openId,String id, String createTime, String modifyTime, BigDecimal wight, BigDecimal height
            , String favoriteTea, int teaAge, String lifeIn, String growthIn, String professional);

}

