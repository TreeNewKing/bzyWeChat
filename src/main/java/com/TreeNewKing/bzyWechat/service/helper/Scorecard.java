package com.TreeNewKing.bzyWechat.service.helper;

import java.util.HashMap;
import java.util.Map;

public class Scorecard {
    private Map<String,Integer> card;

    public Scorecard() {
        HashMap<String, Integer> scorecard = new HashMap<>();
        scorecard.put("1",0);
        scorecard.put("2",0);
        scorecard.put("3",0);
        scorecard.put("4",0);
        scorecard.put("5",0);
        scorecard.put("6",0);
        card=scorecard;
    }

    //加分
    public void add(String bodyTypeId,Integer integer){
        card.put(bodyTypeId,card.get(bodyTypeId)+integer);
    }

}
