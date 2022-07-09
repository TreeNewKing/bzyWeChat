package com.TreeNewKing.bzyWechat.service.impl;


import cn.hutool.core.util.StrUtil;
import com.TreeNewKing.bzyWechat.dao.SurveyRecordMapper;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.TreeNewKing.bzyWechat.service.SurveyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;

/**
 * 填写记录表;(survey_record)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-7-9
 */
@Service
public class SurveyRecordServiceImpl implements SurveyRecordService {
    @Autowired
    private SurveyRecordMapper surveyRecordMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public SurveyRecord queryById(String id){
        return surveyRecordMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param surveyRecord 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<SurveyRecord> paginQuery(SurveyRecord surveyRecord, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<SurveyRecord> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(surveyRecord.getUserId())){
            queryWrapper.eq(SurveyRecord::getUserId, surveyRecord.getUserId());
        }
        if(StrUtil.isNotBlank(surveyRecord.getFavoriteTea())){
            queryWrapper.eq(SurveyRecord::getFavoriteTea, surveyRecord.getFavoriteTea());
        }
        if(StrUtil.isNotBlank(surveyRecord.getLifeIn())){
            queryWrapper.eq(SurveyRecord::getLifeIn, surveyRecord.getLifeIn());
        }
        if(StrUtil.isNotBlank(surveyRecord.getGrowthIn())){
            queryWrapper.eq(SurveyRecord::getGrowthIn, surveyRecord.getGrowthIn());
        }
        if(StrUtil.isNotBlank(surveyRecord.getProfessional())){
            queryWrapper.eq(SurveyRecord::getProfessional, surveyRecord.getProfessional());
        }
        //2. 执行分页查询
        Page<SurveyRecord> pagin = new Page<>(current , size , true);
        IPage<SurveyRecord> selectResult = surveyRecordMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param surveyRecord 实例对象
     * @return 实例对象
     */
    public SurveyRecord insert(SurveyRecord surveyRecord){
        surveyRecordMapper.insert(surveyRecord);
        return surveyRecord;
    }

    /**
     * 更新数据
     *
     * @param surveyRecord 实例对象
     * @return 实例对象
     */
    public SurveyRecord update(SurveyRecord surveyRecord){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<SurveyRecord> chainWrapper = new LambdaUpdateChainWrapper<SurveyRecord>(surveyRecordMapper);
        if(StrUtil.isNotBlank(surveyRecord.getUserId())){
            chainWrapper.eq(SurveyRecord::getUserId, surveyRecord.getUserId());
        }
        if(StrUtil.isNotBlank(surveyRecord.getFavoriteTea())){
            chainWrapper.eq(SurveyRecord::getFavoriteTea, surveyRecord.getFavoriteTea());
        }
        if(StrUtil.isNotBlank(surveyRecord.getLifeIn())){
            chainWrapper.eq(SurveyRecord::getLifeIn, surveyRecord.getLifeIn());
        }
        if(StrUtil.isNotBlank(surveyRecord.getGrowthIn())){
            chainWrapper.eq(SurveyRecord::getGrowthIn, surveyRecord.getGrowthIn());
        }
        if(StrUtil.isNotBlank(surveyRecord.getProfessional())){
            chainWrapper.eq(SurveyRecord::getProfessional, surveyRecord.getProfessional());
        }
        //2. 设置主键，并更新
        chainWrapper.set(SurveyRecord::getId, surveyRecord.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(surveyRecord.getId());
        }else{
            return surveyRecord;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = surveyRecordMapper.deleteById(id);
        return total > 0;
    }
}