package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.ProblemBankResp;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
@Log4j2
@Api(tags="SurveyController:调查问卷控制器")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(@Autowired SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/info")
    public ApiResponse getHistoryInfo(@RequestHeader("Authorization") String token){
        //TODO 获取调查问卷
        HistoryInfoResp historyInfoResp = new HistoryInfoResp();
        historyInfoResp.setHeight(179.0);
        historyInfoResp.setLifeIn("成都");
        historyInfoResp.setTeaAge(18);
        historyInfoResp.setProfessional("程序员");
        return ApiResponse.ok(historyInfoResp);
    }


    @GetMapping
    @Cacheable("problemBank")
    public ApiResponse getQuestionBank(){
        List<Problem> problemBank = surveyService.getProblemBank();
        return ApiResponse.ok(ProblemBankResp.toResp(problemBank));
    }


    @PostMapping("/submit")
    public ApiResponse submit(@RequestHeader("Authorization") String token, @RequestBody SubmitReq submitReq){
        //TODO 问卷调查提交
        return ApiResponse.ok();
    }
}
