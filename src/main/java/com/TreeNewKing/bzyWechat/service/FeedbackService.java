package com.TreeNewKing.bzyWechat.service;


import com.TreeNewKing.bzyWechat.model.entity.Feedback;
import com.TreeNewKing.bzyWechat.model.req.FeedbackReq;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface FeedbackService {
    void insertFeedbackToDb(Feedback feedBack) throws Exception;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Feedback queryById(String id);

    /**
     * 分页查询
     *
     * @param feedback 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Feedback> paginQuery(Feedback feedback, long current, long size);
    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback insert(Feedback feedback);
    /**
     * 更新数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback update(Feedback feedback);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}
