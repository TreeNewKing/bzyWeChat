package com.TreeNewKing.bzyWechat.model.req;

import com.TreeNewKing.bzyWechat.model.req.SubmitInfo;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;



/**
 * TiJiaoWenJuanQingQiu
 */


@Data
public class SubmitReq {
  @JsonProperty("problem")
  private List<SubmitProblem> problem = new ArrayList<>();

  @JsonProperty("info")
  private SubmitInfo info;


}

