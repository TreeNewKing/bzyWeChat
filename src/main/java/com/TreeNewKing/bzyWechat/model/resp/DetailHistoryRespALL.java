package com.TreeNewKing.bzyWechat.model.resp;

import com.TreeNewKing.bzyWechat.model.entity.BodyType;
import com.TreeNewKing.bzyWechat.model.entity.TeaRecommend;
import lombok.Data;

import java.util.List;
@Data
public class DetailHistoryRespALL {

    HistoryInfoResp info;
    List<DetailHistoryResp>problem;
    List<BodyTypeResult> bodyTypes;

}
