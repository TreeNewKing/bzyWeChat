package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.ProblemMapper;
import com.TreeNewKing.bzyWechat.model.entity.Option;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final ProblemMapper problemMapper;

    public SurveyServiceImpl(@Autowired ProblemMapper problemMapper) {
        this.problemMapper = problemMapper;
    }

    @Override
    public List<Problem> getProblemBank() {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("order_by");
        List<Problem> problems = problemMapper.selectList(queryWrapper);
        for (Problem problem : problems) {
            // 如果问题类型为0的话 为简单问题
            if(problem.getType()==0){
                problem.setOptionList(Option.simpleOption);
            }else{
                //TODO 非简单问题
            }
        }
        return problems;
    }
}
