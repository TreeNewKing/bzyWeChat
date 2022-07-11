package com.TreeNewKing.bzyWechat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.TreeNewKing.bzyWechat.model.entity.TeaRecommend;

 /**
 * 茶推荐表;(tea_recommend)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
public interface TeaRecommendService{

    TeaRecommend queryByBodyId(String bodyId);
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return 实例对象
     */
    TeaRecommend queryById(String id);
    
    /**
     * 分页查询
     *
     * @param teaRecommend 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<TeaRecommend> paginQuery(TeaRecommend teaRecommend, long current, long size);
    /** 
     * 新增数据
     *
     * @param teaRecommend 实例对象
     * @return 实例对象
     */
    TeaRecommend insert(TeaRecommend teaRecommend);
    /** 
     * 更新数据
     *
     * @param teaRecommend 实例对象
     * @return 实例对象
     */
    TeaRecommend update(TeaRecommend teaRecommend);
    /** 
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}