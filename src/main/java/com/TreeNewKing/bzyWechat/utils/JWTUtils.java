package com.TreeNewKing.bzyWechat.utils;

import com.TreeNewKing.bzyWechat.common.Constant;
import com.TreeNewKing.bzyWechat.model.entity.User;
import com.TreeNewKing.bzyWechat.model.resp.LoginResp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class JWTUtils {
    public static LoginResp getToken(User user){
        LocalDateTime localDateTime=LocalDateTime.now().plusDays(1);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        String token = JWT.create()
                .withClaim("userId",user.getId() )
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(Constant.JWT_KEY));
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(token);
        loginResp.setExpirationTime(date);
        return loginResp;
    }
}
