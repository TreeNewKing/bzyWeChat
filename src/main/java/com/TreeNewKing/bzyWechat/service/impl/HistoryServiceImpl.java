package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.HistoryMapper;
import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeResult;
import com.TreeNewKing.bzyWechat.model.resp.DetailHistoryResp;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.SimpHistoryResp;
import com.TreeNewKing.bzyWechat.service.HistoryService;
import com.TreeNewKing.bzyWechat.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
@Autowired
  private   HistoryMapper historyMapper;
    @Override
    public List<SimpHistoryResp> getSimpleHistoty(String token) {

        JWTUtils.JWTDto jwtDto = JWTUtils.getJWTDto(token);
      return   historyMapper.getSimpleHistiry(jwtDto.getUserId());
    }

  @Override
  public List<DetailHistoryResp> DetailHistoty(String token, String id) {
    JWTUtils.JWTDto jwtDto = JWTUtils.getJWTDto(token);
    List<DetailHistoryResp> detailHistoryResp=historyMapper.getDetailHistory(id);
    return detailHistoryResp;
  }

  @Override
  public HistoryInfoResp getUserInfo(String id) {
   return   historyMapper.getUserInfo(id);
  }

  @Override
  public List<BodyTypeResult> getBodyTypes(String id) {
   return historyMapper.getBodyTypes(id);
  }
}
