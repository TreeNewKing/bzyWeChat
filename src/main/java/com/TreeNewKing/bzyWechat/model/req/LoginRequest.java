package com.TreeNewKing.bzyWechat.model.req;

import lombok.Data;

@Data
public class LoginRequest {
    private String code;
    private String avatar;
    private String nickname;
}
