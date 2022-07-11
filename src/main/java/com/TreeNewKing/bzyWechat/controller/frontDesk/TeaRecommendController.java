package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.model.entity.TeaRecommend;
import com.TreeNewKing.bzyWechat.service.TeaRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teaRecommend")
public class TeaRecommendController {

    @Autowired
    private TeaRecommendService teaRecommendService;
    @GetMapping
    public ApiResponse getByBodyId(@RequestParam("bodyType_id") String bodyTypeId){
        TeaRecommend teaRecommend = teaRecommendService.queryByBodyId(bodyTypeId);
        return ApiResponse.ok(teaRecommend);
    }

}
