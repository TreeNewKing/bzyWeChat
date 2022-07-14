package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.model.resp.SubmitResp;

import java.util.List;

public interface SurveyService {
    List<Problem> getProblemBank();
    SurveyRecord getRecentInfo(String userId);

    SubmitResp submit(String userId, SubmitReq submitReq);
}
