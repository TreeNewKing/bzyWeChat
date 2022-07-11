package com.TreeNewKing.bzyWechat.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.TreeNewKing.bzyWechat.model.entity.TeaRecommend;

 /**
 * 茶推荐表;(tea_recommend)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@Mapper
public interface TeaRecommendMapper  extends BaseMapper<TeaRecommend>{
    /** 
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<TeaRecommend> selectByPage(IPage<TeaRecommend> page , @Param(Constants.WRAPPER) Wrapper<TeaRecommend> wrapper);
}