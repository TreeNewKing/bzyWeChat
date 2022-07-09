package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;

import java.util.List;

public interface SurveyService {
    List<Problem> getProblemBank();
    SurveyRecord getRecentInfo(String userId);
}
