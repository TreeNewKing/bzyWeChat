package com.TreeNewKing.bzyWechat.service.helper;


import com.TreeNewKing.bzyWechat.dao.BodyTypeMapper;
import com.TreeNewKing.bzyWechat.dao.OptionScoreMapper;
import com.TreeNewKing.bzyWechat.error.AppException;
import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.entity.OptionScore;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用来记录分数关系
@Component
public class ScoresRelationship {
    @Autowired
    private OptionScoreMapper optionScoreMapper;
    @Autowired
    private BodyTypeMapper bodyTypeMapper;

    private Map<String,String> bodyTypeFindName;
    @PostConstruct
    public void init(){
        List<OptionScore> optionScores = optionScoreMapper.selectList(new QueryWrapper<>());
        simpleScoringRules=new SimpleScoringRules();
        // 构建简单分数规则
        for (OptionScore optionScore : optionScores) {
            simpleScoringRules.build(optionScore);
        }
        bodyTypeFindName=new HashMap<>();
        List<BodyType> bodyTypes = bodyTypeMapper.selectList(new QueryWrapper<>());
        if (bodyTypes!=null){
            for (BodyType bodyType : bodyTypes) {
                bodyTypeFindName.put(bodyType.getId(),bodyType.getName());
            }
        }
    }
    private SimpleScoringRules simpleScoringRules;

    public void recordScore(SubmitProblem submitProblem, Scorecard scorecard){
        switch (submitProblem.getType()){
            //根据类型来选择 适当的 简单分数规则来进行操作 因为只有一种就先定死了
            case 0:
                simpleScoringRules.score(submitProblem,scorecard);
                break;
            default:
                //TODO 更多类型
                throw new AppException();
        }
    }

    public String findBodyTypeName(String bodyTypeId){
        String s = bodyTypeFindName.get(bodyTypeId);
        if(s==null){
            throw new AppException();
        }
        return s;
    }

}
