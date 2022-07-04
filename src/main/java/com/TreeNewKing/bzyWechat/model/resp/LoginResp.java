package com.TreeNewKing.bzyWechat.model.resp;


import lombok.Data;

import java.util.Date;

@Data
public class LoginResp {

    private String token;
    private Date expirationTime;

}
