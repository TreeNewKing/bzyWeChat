package com.TreeNewKing.bzyWechat.model.resp;

import lombok.Data;

@Data
public class AuthResp {
    private String openid;
    private String sessionKey;
    private String unionid;
    private Integer errcode;
    private String errmsg;
}
