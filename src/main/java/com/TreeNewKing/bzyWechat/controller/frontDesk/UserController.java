package com.TreeNewKing.bzyWechat.controller.frontDesk;


import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.model.entity.User;
import com.TreeNewKing.bzyWechat.model.req.LoginRequest;
import com.TreeNewKing.bzyWechat.model.resp.LoginResp;

import com.TreeNewKing.bzyWechat.service.UserService;

import com.TreeNewKing.bzyWechat.utils.JWTUtils;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Log4j2
@Api(tags="UserController(frontDesk):用户管理接口")
public class UserController {
    final UserService userService;


    public UserController(@Autowired UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest loginRequest){
        log.info("/api/user/login post request, code: {}", loginRequest.getCode());
        User user = userService.login(loginRequest);
        LoginResp loginResp = JWTUtils.getToken(user);
        return ApiResponse.ok(loginResp);
    }




}
