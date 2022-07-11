package com.TreeNewKing.bzyWechat.service.impl;

import cn.hutool.core.util.StrUtil;
import com.TreeNewKing.bzyWechat.dao.FeedbackMapper;
import com.TreeNewKing.bzyWechat.model.entity.Feedback;
import com.TreeNewKing.bzyWechat.model.req.FeedbackReq;
import com.TreeNewKing.bzyWechat.service.FeedbackService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
   private FeedbackMapper feedBackMapper;

    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Feedback queryById(String id){
        return feedbackMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param feedback 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Feedback> paginQuery(Feedback feedback, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Feedback> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(feedback.getTitle())){
            queryWrapper.eq(Feedback::getTitle, feedback.getTitle());
        }
        if(StrUtil.isNotBlank(feedback.getDescription())){
            queryWrapper.eq(Feedback::getDescription, feedback.getDescription());
        }
        if(StrUtil.isNotBlank(feedback.getEmail())){
            queryWrapper.eq(Feedback::getEmail, feedback.getEmail());
        }
        if(StrUtil.isNotBlank(feedback.getUserId())){
            queryWrapper.eq(Feedback::getUserId, feedback.getUserId());
        }
        if(StrUtil.isNotBlank(feedback.getMemo())){
            queryWrapper.eq(Feedback::getMemo, feedback.getMemo());
        }
        //2. 执行分页查询
        Page<Feedback> pagin = new Page<>(current , size , true);
        IPage<Feedback> selectResult = feedbackMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    public Feedback insert(Feedback feedback){
        feedbackMapper.insert(feedback);
        return feedback;
    }

    /**
     * 更新数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    public Feedback update(Feedback feedback){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Feedback> chainWrapper = new LambdaUpdateChainWrapper<Feedback>(feedbackMapper);
        if(StrUtil.isNotBlank(feedback.getTitle())){
            chainWrapper.eq(Feedback::getTitle, feedback.getTitle());
        }
        if(StrUtil.isNotBlank(feedback.getDescription())){
            chainWrapper.eq(Feedback::getDescription, feedback.getDescription());
        }
        if(StrUtil.isNotBlank(feedback.getEmail())){
            chainWrapper.eq(Feedback::getEmail, feedback.getEmail());
        }
        if(StrUtil.isNotBlank(feedback.getUserId())){
            chainWrapper.eq(Feedback::getUserId, feedback.getUserId());
        }
        if(StrUtil.isNotBlank(feedback.getMemo())){
            chainWrapper.eq(Feedback::getMemo, feedback.getMemo());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Feedback::getId, feedback.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(feedback.getId());
        }else{
            return feedback;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = feedbackMapper.deleteById(id);
        return total > 0;
    }


    public void insertFeedbackToDb(Feedback feedBack) throws Exception{
        Date date = new Date();
        feedBack.setCreateTime(date);
        feedBack.setModifyTime(date);
        feedBack.setState(0);
        feedbackMapper.insert(feedBack);
    }
}
