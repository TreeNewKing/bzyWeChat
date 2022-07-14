package com.TreeNewKing.bzyWechat.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.dao.BodyTypeMapper;
import com.TreeNewKing.bzyWechat.service.BodyTypeService;

import java.util.List;

/**
 * 体质类型表;(body_type)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@Service
@Slf4j
public class BodyTypeServiceImpl implements BodyTypeService{
    @Autowired
    private BodyTypeMapper bodyTypeMapper;

    @Override
    @Cacheable("allBodyType")
    public List<BodyType> findAllBodyType() {
        log.info("获取全部体质类型");
        return bodyTypeMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return 实例对象
     */
    public BodyType queryById(String id){
        return bodyTypeMapper.selectById(id);
    }
    
    /**
     * 分页查询
     *
     * @param bodyType 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<BodyType> paginQuery(BodyType bodyType, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<BodyType> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(bodyType.getName())){
            queryWrapper.eq(BodyType::getName, bodyType.getName());
        }
        if(StrUtil.isNotBlank(bodyType.getDescribe())){
            queryWrapper.eq(BodyType::getDescribe, bodyType.getDescribe());
        }
        if(StrUtil.isNotBlank(bodyType.getPicture())){
            queryWrapper.eq(BodyType::getPicture, bodyType.getPicture());
        }
        //2. 执行分页查询
        Page<BodyType> pagin = new Page<>(current , size , true);
        IPage<BodyType> selectResult = bodyTypeMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param bodyType 实例对象
     * @return 实例对象
     */
    public BodyType insert(BodyType bodyType){
        bodyTypeMapper.insert(bodyType);
        return bodyType;
    }
    
    /** 
     * 更新数据
     *
     * @param bodyType 实例对象
     * @return 实例对象
     */
    public BodyType update(BodyType bodyType){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<BodyType> chainWrapper = new LambdaUpdateChainWrapper<BodyType>(bodyTypeMapper);
        if(StrUtil.isNotBlank(bodyType.getName())){
            chainWrapper.eq(BodyType::getName, bodyType.getName());
        }
        if(StrUtil.isNotBlank(bodyType.getDescribe())){
            chainWrapper.eq(BodyType::getDescribe, bodyType.getDescribe());
        }
        if(StrUtil.isNotBlank(bodyType.getPicture())){
            chainWrapper.eq(BodyType::getPicture, bodyType.getPicture());
        }
        //2. 设置主键，并更新
        chainWrapper.set(BodyType::getId, bodyType.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(bodyType.getId());
        }else{
            return bodyType;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = bodyTypeMapper.deleteById(id);
        return total > 0;
    }
}