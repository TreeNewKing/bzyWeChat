package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.Problem;

import java.util.List;

public interface SurveyService {
    List<Problem> getProblemBank();

    int insertRecordDetail(String id,String recordId, String optionsId, Integer type);
   int  insertBodyTypeOfSur(String bodyTypeId,String recordId,int result);
}
