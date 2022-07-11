package com.TreeNewKing.bzyWechat.model.req;

import lombok.Data;

@Data
public class FeedbackReq {
    private  String title;
    private  String description;
    private  String email;
}
