package com.TreeNewKing.bzyWechat.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.TreeNewKing.bzyWechat.model.entity.BodyType;

 /**
 * 体质类型表;(body_type)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@Mapper
public interface BodyTypeMapper  extends BaseMapper<BodyType>{
    /** 
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<BodyType> selectByPage(IPage<BodyType> page , @Param(Constants.WRAPPER) Wrapper<BodyType> wrapper);
}