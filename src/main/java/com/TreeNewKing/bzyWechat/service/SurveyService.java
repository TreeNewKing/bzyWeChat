package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;

import java.util.List;

public interface SurveyService {
    List<Problem> getProblemBank();
    SurveyRecord getRecentInfo(String userId);

    void submit(String userId, SubmitReq submitReq);
}
