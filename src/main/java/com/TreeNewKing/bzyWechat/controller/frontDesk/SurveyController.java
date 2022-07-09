package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.dao.ScoreMapper;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.ScoreTab;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;
import com.TreeNewKing.bzyWechat.model.resp.HistoryInfoResp;
import com.TreeNewKing.bzyWechat.model.resp.ProblemBankResp;
import com.TreeNewKing.bzyWechat.service.BodyTypeService;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import com.TreeNewKing.bzyWechat.service.UserService;
import com.TreeNewKing.bzyWechat.utils.TimeStampUtils;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/survey")
@Log4j2
@Api(tags="SurveyController:调查问卷控制器")
public class SurveyController {
@Autowired
 private    UserService userService;
    private final SurveyService surveyService;
@Autowired
 private BodyTypeService bodyTypeService;
@Autowired
private ScoreMapper scoreMapper;

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


//    @PostMapping("/submit")
//    public ApiResponse submit(@RequestHeader("Authorization") String token, @RequestBody SubmitReq submitReq){
//        //TODO 问卷调查提交
//        return ApiResponse.ok();
//    }
    @PostMapping("/submit")
    public ApiResponse submit(@RequestHeader("Authorization") String token, @RequestBody SubmitReq submitReq){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        SubmitReq.Info info = submitReq.getInfo();
        List<SubmitReq.Problem> problems = submitReq.getProblem();

        String openId="1";
       String time= TimeStampUtils.getFormateTime();
        /*用户基本信息填入*/
        userService.insertPrimaryInfoByOpenId(openId,uuid,time,time,info.getWight(),info.getHeight(),info.getFavoriteTea(),info.getTeaAge(),info.getLifeIn(),info.getGrowthIn(),info.getProfessional());

        Map bodyTypeId_score=new HashMap();                     //创建体质和得分映射
            List<BodyTypeRespAll> allBodyType = bodyTypeService.getAllBodyType();//获取所有体质类型
            List<ScoreTab> scoreTable = scoreMapper.getScoreTable();//获取得分表
        /*问题填写情况存入*/
        for (SubmitReq.Problem problem : problems) {//遍历用户填如内容
            for (BodyTypeRespAll bodyType : allBodyType) {//循环每一种体质
                bodyTypeId_score.put(bodyType.getId(),0);
                for (ScoreTab scoreTab : scoreTable) { //遍历得分表

                    if (bodyType.getId().equals(scoreTab.getBodyTypeId())){  //只有得分表体质类型和当前判断类型相等时才操作
                           int  oldScore= (int) bodyTypeId_score.get(bodyType.getId());
                           bodyTypeId_score.put(bodyType.getId(),oldScore+Integer.valueOf(problem.getOptionsId()));//optionsId 为1-5直接相加



                    }

                }

            }


                /*记录体质鉴定结果*/
                int result= (int) bodyTypeId_score.get(bodyType.getId());
                int rs=surveyService.insertBodyTypeOfSur(bodyType.getId(),uuid,result);

            surveyService.insertRecordDetail(problem.getId(),uuid,problem.getOptionsId(),problem.getType());
        }
        /*体质类型判断填入*/




        return ApiResponse.ok();
    }


}
