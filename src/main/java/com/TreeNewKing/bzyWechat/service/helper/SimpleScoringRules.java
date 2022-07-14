package com.TreeNewKing.bzyWechat.service.helper;

import com.TreeNewKing.bzyWechat.model.entity.OptionScore;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 当 积分表 数据代表的是 表与分数的关系时 使用该 Table
public class SimpleScoringRules {

    // key 是 题号 value是体质类型
    private Map<String, List<String>> positiveScoreMap;
    private Map<String,List<String>> reverseScoreMap;

    public SimpleScoringRules() {
        positiveScoreMap=new HashMap<>();
        reverseScoreMap=new HashMap<>();

    }

    // 构建得分表
    public void build(OptionScore optionScore){
        String itemId = optionScore.getItemId();
        if(optionScore.getScore()>0){
            List<String> positiveList = positiveScoreMap.getOrDefault(itemId, new ArrayList<>());
            positiveList.add(optionScore.getBodyTypeId());
            positiveScoreMap.put(itemId,positiveList);
        }else{
            List<String> reverseList = reverseScoreMap.getOrDefault(itemId, new ArrayList<>());
            reverseList.add(optionScore.getBodyTypeId());
            reverseScoreMap.put(itemId,reverseList);
        }
    }

    // 在计分表上计分
    public void score(SubmitProblem submitProblem, Scorecard scorecard){
        List<String> positiveList = positiveScoreMap.get(submitProblem.getId());
        if (positiveList!=null){
            for (String s : positiveList) {
                Integer increase = Integer.parseInt(submitProblem.getOptionsId());
                scorecard.add(s, increase);
            }
        }
        List<String> reverseScoreList = reverseScoreMap.get(submitProblem.getId());
        if(reverseScoreList!=null){
            for (String s : reverseScoreList) {
                Integer increase = (5 - Integer.parseInt(submitProblem.getOptionsId())) % 5 + 1;
                scorecard.add(s, increase);
            }
        }
    }

}
