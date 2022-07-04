package com.TreeNewKing.bzyWechat.service.impl;


import cn.hutool.core.util.StrUtil;
import com.TreeNewKing.bzyWechat.dao.ProblemMapper;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;

/**
 * 问题表;(problem)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2022-7-3
 */
@Service
public class ProblemServiceImpl implements ProblemService{
    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Problem queryById(String id){
        return problemMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param problem 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Problem> paginQuery(Problem problem, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Problem> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(problem.getDescription())){
            queryWrapper.eq(Problem::getDescription, problem.getDescription());
        }
        //2. 执行分页查询
        Page<Problem> pagin = new Page<>(current , size , true);
        IPage<Problem> selectResult = problemMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    public Problem insert(Problem problem){
        problemMapper.insert(problem);
        return problem;
    }

    /**
     * 更新数据
     *
     * @param problem 实例对象
     * @return 实例对象
     */
    public Problem update(Problem problem){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Problem> chainWrapper = new LambdaUpdateChainWrapper<Problem>(problemMapper);
        if(StrUtil.isNotBlank(problem.getDescription())){
            chainWrapper.eq(Problem::getDescription, problem.getDescription());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Problem::getId, problem.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(problem.getId());
        }else{
            return problem;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(String id){
        int total = problemMapper.deleteById(id);
        return total > 0;
    }
}