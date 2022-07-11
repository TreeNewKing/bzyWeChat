package com.TreeNewKing.bzyWechat.service.helper;

import com.TreeNewKing.bzyWechat.model.entity.OptionScore;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 当 积分表 数据代表的是 表与分数的关系时 使用该 Table
public class IntegralHelperWithTable {
    private Map<String, List<String>> positiveScoreMap;
    private Map<String,List<String>> reverseScoreMap;

    public IntegralHelperWithTable() {
        positiveScoreMap=new HashMap<>();
        reverseScoreMap=new HashMap<>();
        positiveScoreMap.put("1",new ArrayList<>());
        positiveScoreMap.put("2",new ArrayList<>());
        positiveScoreMap.put("3",new ArrayList<>());
        positiveScoreMap.put("4",new ArrayList<>());
        positiveScoreMap.put("5",new ArrayList<>());
        positiveScoreMap.put("6",new ArrayList<>());
        reverseScoreMap.put("1",new ArrayList<>());
        reverseScoreMap.put("2",new ArrayList<>());
        reverseScoreMap.put("3",new ArrayList<>());
        reverseScoreMap.put("4",new ArrayList<>());
        reverseScoreMap.put("5",new ArrayList<>());
        reverseScoreMap.put("6",new ArrayList<>());
    }

    // 构建得分表
    public void build(OptionScore optionScore){
        List<String> option;
        if(optionScore.getScore()>0){
            option = positiveScoreMap.get(optionScore.getId());
        }else{
            option = reverseScoreMap.get(optionScore.getId());
        }
        option.add(optionScore.getBodyTypeId());
    }

    // 在计分表上计分
    public void score(SubmitProblem submitProblem, Scorecard scorecard){
        List<String> positiveList = positiveScoreMap.get(submitProblem.getId());
        for (String s : positiveList) {
            Integer increase=Integer.parseInt(s);
            scorecard.add(s,increase);
        }
        List<String> reverseScoreList = reverseScoreMap.get(submitProblem.getId());
        for (String s : reverseScoreList) {
            Integer increase=(5-Integer.parseInt(s))%5+1;
            scorecard.add(s,increase);
        }
    }

}
