package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.RecordDetail;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


 /**
 * 填写记录详情;(record_detail)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-7-15
 */
@Mapper
public interface RecordDetailMapper  extends BaseMapper<RecordDetail>{

}