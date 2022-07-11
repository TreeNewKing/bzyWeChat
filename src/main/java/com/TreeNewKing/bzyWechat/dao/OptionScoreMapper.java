package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.OptionScore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


 /**
 * 选项与对应分数的对应;(option_score)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@Mapper
public interface OptionScoreMapper  extends BaseMapper<OptionScore>{
    /** 
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<OptionScore> selectByPage(IPage<OptionScore> page , @Param(Constants.WRAPPER) Wrapper<OptionScore> wrapper);
}