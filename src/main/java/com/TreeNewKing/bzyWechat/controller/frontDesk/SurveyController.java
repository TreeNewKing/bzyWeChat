package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.ProblemBankResp;
import com.TreeNewKing.bzyWechat.model.resp.SubmitResp;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import com.TreeNewKing.bzyWechat.utils.JWTUtils;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
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
        log.info("获取历史个人信息");
        JWTUtils.JWTDto jwtDto = JWTUtils.getJWTDto(token);
        SurveyRecord recentInfo = surveyService.getRecentInfo(jwtDto.getUserId());
        HistoryInfoResp historyInfoResp = new HistoryInfoResp();
        if(recentInfo!=null){
            BeanUtils.copyProperties(recentInfo, historyInfoResp);
        }else{
            log.info("之前无提交记录，获取历史个人信息失败!");
        }
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
        JWTUtils.JWTDto jwtDto = JWTUtils.getJWTDto(token);
        log.info("用户提交问卷 userID:"+ jwtDto.getUserId()+" 个人信息:"+submitReq.getInfo());
        SubmitResp submitResp = surveyService.submit(jwtDto.getUserId(), submitReq);
//        SubmitResp submitResp = surveyService.submit("demo", submitReq);
        return ApiResponse.ok(submitResp);
    }
}
