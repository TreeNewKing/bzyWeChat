package com.TreeNewKing.bzyWechat.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.TreeNewKing.bzyWechat.model.entity.TeaRecommend;
import com.TreeNewKing.bzyWechat.dao.TeaRecommendMapper;
import com.TreeNewKing.bzyWechat.service.TeaRecommendService;
 /**
 * 茶推荐表;(tea_recommend)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@Service
public class TeaRecommendServiceImpl implements TeaRecommendService{
    @Autowired
    private TeaRecommendMapper teaRecommendMapper;

     @Override
     public TeaRecommend queryByBodyId(String bodyId) {
         QueryWrapper<TeaRecommend> queryWrapper = new QueryWrapper<TeaRecommend>().eq("body_type_id", bodyId);
         TeaRecommend teaRecommend = teaRecommendMapper.selectOne(queryWrapper);
         return teaRecommend;
     }

     /**
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return 实例对象
     */
    public TeaRecommend queryById(String id){
        return teaRecommendMapper.selectById(id);
    }
    
    /**
     * 分页查询
     *
     * @param teaRecommend 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<TeaRecommend> paginQuery(TeaRecommend teaRecommend, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<TeaRecommend> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(teaRecommend.getBodyTypeId())){
            queryWrapper.eq(TeaRecommend::getBodyTypeId, teaRecommend.getBodyTypeId());
        }
        if(StrUtil.isNotBlank(teaRecommend.getDrinkingAdvice())){
            queryWrapper.eq(TeaRecommend::getDrinkingAdvice, teaRecommend.getDrinkingAdvice());
        }
        if(StrUtil.isNotBlank(teaRecommend.getMorningTea())){
            queryWrapper.eq(TeaRecommend::getMorningTea, teaRecommend.getMorningTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getAfternoonTea())){
            queryWrapper.eq(TeaRecommend::getAfternoonTea, teaRecommend.getAfternoonTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getEvenTea())){
            queryWrapper.eq(TeaRecommend::getEvenTea, teaRecommend.getEvenTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSpringTea())){
            queryWrapper.eq(TeaRecommend::getSpringTea, teaRecommend.getSpringTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSummerTea())){
            queryWrapper.eq(TeaRecommend::getSummerTea, teaRecommend.getSummerTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getAutumnTea())){
            queryWrapper.eq(TeaRecommend::getAutumnTea, teaRecommend.getAutumnTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getWinterTea())){
            queryWrapper.eq(TeaRecommend::getWinterTea, teaRecommend.getWinterTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSpecialTea())){
            queryWrapper.eq(TeaRecommend::getSpecialTea, teaRecommend.getSpecialTea());
        }
        //2. 执行分页查询
        Page<TeaRecommend> pagin = new Page<>(current , size , true);
        IPage<TeaRecommend> selectResult = teaRecommendMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }
    
    /** 
     * 新增数据
     *
     * @param teaRecommend 实例对象
     * @return 实例对象
     */
    public TeaRecommend insert(TeaRecommend teaRecommend){
        teaRecommendMapper.insert(teaRecommend);
        return teaRecommend;
    }
    
    /** 
     * 更新数据
     *
     * @param teaRecommend 实例对象
     * @return 实例对象
     */
    public TeaRecommend update(TeaRecommend teaRecommend){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<TeaRecommend> chainWrapper = new LambdaUpdateChainWrapper<TeaRecommend>(teaRecommendMapper);
        if(StrUtil.isNotBlank(teaRecommend.getBodyTypeId())){
            chainWrapper.eq(TeaRecommend::getBodyTypeId, teaRecommend.getBodyTypeId());
        }
        if(StrUtil.isNotBlank(teaRecommend.getDrinkingAdvice())){
            chainWrapper.eq(TeaRecommend::getDrinkingAdvice, teaRecommend.getDrinkingAdvice());
        }
        if(StrUtil.isNotBlank(teaRecommend.getMorningTea())){
            chainWrapper.eq(TeaRecommend::getMorningTea, teaRecommend.getMorningTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getAfternoonTea())){
            chainWrapper.eq(TeaRecommend::getAfternoonTea, teaRecommend.getAfternoonTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getEvenTea())){
            chainWrapper.eq(TeaRecommend::getEvenTea, teaRecommend.getEvenTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSpringTea())){
            chainWrapper.eq(TeaRecommend::getSpringTea, teaRecommend.getSpringTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSummerTea())){
            chainWrapper.eq(TeaRecommend::getSummerTea, teaRecommend.getSummerTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getAutumnTea())){
            chainWrapper.eq(TeaRecommend::getAutumnTea, teaRecommend.getAutumnTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getWinterTea())){
            chainWrapper.eq(TeaRecommend::getWinterTea, teaRecommend.getWinterTea());
        }
        if(StrUtil.isNotBlank(teaRecommend.getSpecialTea())){
            chainWrapper.eq(TeaRecommend::getSpecialTea, teaRecommend.getSpecialTea());
        }
        //2. 设置主键，并更新
        chainWrapper.set(TeaRecommend::getId, teaRecommend.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(teaRecommend.getId());
        }else{
            return teaRecommend;
        }
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = teaRecommendMapper.deleteById(id);
        return total > 0;
    }
}