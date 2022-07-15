package com.TreeNewKing.bzyWechat.model.resp;

import lombok.Data;

import java.util.List;

@Data
public class DetailHistoryResp {

    private int sequence;
    private String time;
    private String description;
    private String options;

}
