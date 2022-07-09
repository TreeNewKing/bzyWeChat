package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProblemMapper  extends BaseMapper<Problem> {
    /**
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<Problem> selectByPage(IPage<Problem> page , @Param(Constants.WRAPPER) Wrapper<Problem> wrapper);

    int insertRecordDetail(String problemId, String recordId,String optionsId, Integer type);
}
