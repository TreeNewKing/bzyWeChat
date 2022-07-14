package com.TreeNewKing.bzyWechat.service.helper;

import java.util.HashMap;
import java.util.Map;

public class Scorecard {
    private Map<String, Integer> card;
    // 分数所对应的结构
    private Map<String, Integer> result;

    public Scorecard() {
        HashMap<String, Integer> scorecard = new HashMap<>();
        scorecard.put("1", 0);
        scorecard.put("2", 0);
        scorecard.put("3", 0);
        scorecard.put("4", 0);
        scorecard.put("5", 0);
        scorecard.put("6", 0);
        scorecard.put("7", 0);
        scorecard.put("8", 0);
        scorecard.put("9", 0);
        card = scorecard;
        result = new HashMap<>();
    }

    //加分
    public void add(String bodyTypeId, Integer integer) {
        card.put(bodyTypeId, card.get(bodyTypeId) + integer);
    }

    //结算结构
    public Map<String, Integer> settlement() {
        //前8项是否有一项未 是 或者 倾向是
        boolean hasTrue = false;
        for (String s : card.keySet()) {
            if (!s.equals("9")) {
                Integer score = card.get(s);
                if (score >= 11) {
                    result.put(s, 1);
                    hasTrue = true;
                } else if (score >= 9) {
                    result.put(s, 2);
                    hasTrue = true;
                } else {
                    result.put(s, 0);
                }
            }
        }
        //计算平和质 分数
        Integer score = card.get("9");
        if (score < 17) {
            result.put("9", 0);
        } else if (hasTrue) {
            result.put("9", 2);
        } else {
            result.put("9", 1);
        }
        return result;
    }

}
