package com.TreeNewKing.bzyWechat.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static String JWT_KEY;
    public static String APP_ID;
    public static String SECRET;

    @Value("${app.jwtKey:token!Q2W#E$RW}")
    public void setJWTToken(String jwtToken){
        JWT_KEY=jwtToken;
    }
    @Value("${app.appId}")
    public void setAppId(String appId){
        APP_ID=appId;
    }


    @Value("${app.secret}")
    public void setSecret(String secret){
        SECRET=secret;
    }
}
