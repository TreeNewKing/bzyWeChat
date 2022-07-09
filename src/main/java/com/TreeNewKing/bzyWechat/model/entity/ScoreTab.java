package com.TreeNewKing.bzyWechat.model.entity;

import lombok.Data;

@Data
public class ScoreTab {
  private   String  id;
    private  String itemId;
    private  String bodyTypeId;
    private  String bodyTypeName;
    private  int   score;
    private  int   type;
}
