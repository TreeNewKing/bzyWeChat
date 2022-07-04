package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * 问题表;(problem)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-7-3
 */
public interface ProblemService{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Problem queryById(String id);

    /**
     * 分页查询
     *
     * @param problem 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Problem> paginQuery(Problem problem, long current, long size);
    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem insert(Problem problem);
    /**
     * 更新数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    Problem update(Problem problem);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}