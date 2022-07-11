package com.TreeNewKing.bzyWechat.utils;

import com.TreeNewKing.bzyWechat.common.Constant;
import com.TreeNewKing.bzyWechat.error.AppException;
import com.TreeNewKing.bzyWechat.model.entity.User;
import com.TreeNewKing.bzyWechat.model.resp.LoginResp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class JWTUtils {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JWTDto{
        private String userId;
        private Integer isAdmin;
    }
    public static String USER_ID_KEY="userId";
    public static String IS_ADMIN_KEY="isAdmin";

    public static LoginResp getToken(User user){
        LocalDateTime localDateTime=LocalDateTime.now().plusDays(1);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        String token = JWT.create()
                .withClaim(USER_ID_KEY,user.getId() )
                .withClaim(IS_ADMIN_KEY,user.getIsAdmin())
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(Constant.JWT_KEY));
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(token);
        loginResp.setExpirationTime(date);
        return loginResp;
    }

    public static JWTDto getJWTDto(String token)throws AppException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constant.JWT_KEY)).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String userId = decodedJWT.getClaim(USER_ID_KEY).asString();
            Integer isAdmin = decodedJWT.getClaim(IS_ADMIN_KEY).asInt();
            return new JWTDto(userId,isAdmin);
        }catch (Exception e){
            throw new AppException();
        }
    }






}
