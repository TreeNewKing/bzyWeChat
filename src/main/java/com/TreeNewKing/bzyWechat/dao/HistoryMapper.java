package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeResult;
import com.TreeNewKing.bzyWechat.model.resp.DetailHistoryResp;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.SimpHistoryResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    List<SimpHistoryResp> getSimpleHistiry(String userId);
    List<DetailHistoryResp> getDetailHistory(String id);

    HistoryInfoResp getUserInfo(String id);

    List<BodyTypeResult> getBodyTypes(String id);
}
