package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.resp.*;
import com.TreeNewKing.bzyWechat.service.HistoryService;
import com.TreeNewKing.bzyWechat.service.TeaRecommendService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@Log4j2
public class HistoryController {
@Autowired
   private HistoryService historyService;
    @Autowired
    private TeaRecommendService teaRecommendService;
@PostMapping("/simple")
    public List<SimpHistoryResp> getSimplHistory(@RequestHeader("Authorization") String token){
    return    historyService.getSimpleHistoty(token);
    }
    @PostMapping("/detail")
    public DetailHistoryRespALL getDetailHistory(@RequestHeader("Authorization") String token, String id){
        DetailHistoryRespALL detailHistoryRespALL=new DetailHistoryRespALL();
        detailHistoryRespALL.setProblem(historyService.DetailHistoty(token,id));
        HistoryInfoResp historyInfoResp= historyService.getUserInfo(id);
        detailHistoryRespALL.setInfo(historyInfoResp);
        List<BodyTypeResult>bodyTypes=historyService.getBodyTypes(id);
        detailHistoryRespALL.setBodyTypes(bodyTypes);
        return detailHistoryRespALL;
    }

}
