package com.TreeNewKing.bzyWechat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.TreeNewKing.bzyWechat.model.entity.BodyType;

import java.util.List;

/**
 * 体质类型表;(body_type)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
public interface BodyTypeService{

    List<BodyType> findAllBodyType();
    /** 
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return 实例对象
     */
    BodyType queryById(String id);
    
    /**
     * 分页查询
     *
     * @param bodyType 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<BodyType> paginQuery(BodyType bodyType, long current, long size);
    /** 
     * 新增数据
     *
     * @param bodyType 实例对象
     * @return 实例对象
     */
    BodyType insert(BodyType bodyType);
    /** 
     * 更新数据
     *
     * @param bodyType 实例对象
     * @return 实例对象
     */
    BodyType update(BodyType bodyType);
    /** 
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);
}