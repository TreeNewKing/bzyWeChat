package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface SurveyRecordService{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SurveyRecord queryById(String id);

    /**
     * 分页查询
     *
     * @param surveyRecord 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<SurveyRecord> paginQuery(SurveyRecord surveyRecord, long current, long size);
    /**
     * 新增数据
     *
     * @param surveyRecord 实例对象
     * @return 实例对象
     */
    SurveyRecord insert(SurveyRecord surveyRecord);
    /**
     * 更新数据
     *
     * @param surveyRecord 实例对象
     * @return 实例对象
     */
    SurveyRecord update(SurveyRecord surveyRecord);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}