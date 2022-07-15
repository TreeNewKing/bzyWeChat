package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeResult;
import com.TreeNewKing.bzyWechat.model.resp.DetailHistoryResp;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.SimpHistoryResp;

import java.util.List;

public interface HistoryService {
    List<SimpHistoryResp> getSimpleHistoty(String userId);

    List<DetailHistoryResp> DetailHistoty(String token, String id);

    HistoryInfoResp getUserInfo(String id);

    List<BodyTypeResult> getBodyTypes(String id);
}
