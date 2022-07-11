package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bodyType")
public class BodyTypeController {

    @Autowired
    private BodyTypeService bodyTypeService;

    @GetMapping
    public ApiResponse getAllBodyType(){
        return ApiResponse.ok(bodyTypeService.findAllBodyType());
    }
}
