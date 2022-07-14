package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.ProblemMapper;
import com.TreeNewKing.bzyWechat.dao.RecordDetailMapper;
import com.TreeNewKing.bzyWechat.dao.SurveyRecordMapper;
import com.TreeNewKing.bzyWechat.dao.SurveyResultMapper;
import com.TreeNewKing.bzyWechat.model.entity.*;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.model.resp.SubmitResp;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import com.TreeNewKing.bzyWechat.service.helper.ScoresRelationship;
import com.TreeNewKing.bzyWechat.service.helper.Scorecard;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private  SurveyRecordMapper surveyRecordMapper;
    @Autowired
    private ScoresRelationship scoresRelationship;
    @Autowired
    private  SurveyResultMapper surveyResultMapper;

    @Autowired
    private RecordDetailMapper recordDetailMapper;

    @Override
    public List<Problem> getProblemBank() {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("order_by");
        List<Problem> problems = problemMapper.selectList(queryWrapper);
        for (Problem problem : problems) {
            // 如果问题类型为0的话 为简单问题
            if(problem.getType()==0){
                problem.setOptionList(Option.simpleOption);
            }else{
                //TODO 非简单问题
            }
        }
        return problems;
    }

    @Override
    public SurveyRecord getRecentInfo(String userId){
        QueryWrapper<SurveyRecord> surveyRecordQueryWrapper = new QueryWrapper<SurveyRecord>().eq("user_id", userId).orderByDesc("create_time").last("limit 1");
        SurveyRecord surveyRecord = surveyRecordMapper.selectOne(surveyRecordQueryWrapper);
        return surveyRecord;
    }

    @Override
    @Transactional
    // 不忘记打开事务
    public SubmitResp submit(String userId, SubmitReq submitReq) {
        SurveyRecord surveyRecord = new SurveyRecord();
        BeanUtils.copyProperties(submitReq.getInfo(),surveyRecord);
        Date date = new Date();
        surveyRecord.setCreateTime(date);
        surveyRecord.setModifyTime(date);
        surveyRecord.setUserId(userId);
        log.info("记录提交记录 userId:"+ userId+"surveyRecord:" +submitReq);
        surveyRecordMapper.insert(surveyRecord);
        String surveyRecordId = surveyRecord.getId();
        List<SubmitProblem> problem = submitReq.getProblem();
        Scorecard scorecard = new Scorecard();
        for (SubmitProblem submitProblem : problem) {
            scoresRelationship.recordScore(submitProblem,scorecard);
        }
        Map<String, Integer> result = scorecard.settlement();
        recordFillInResults(result,surveyRecordId);
        SubmitResp submitResp = new SubmitResp();
        for (String s : result.keySet()) {
            submitResp.build(s, scoresRelationship.findBodyTypeName(s),result.get(s) );
        }
        new Thread(){
            @Override
            public void run() {
                log.info("开始记录 答题细节: userId:"+userId);
                for (SubmitProblem submitProblem : problem) {
                    RecordDetail recordDetail = new RecordDetail();
                    recordDetail.setRecordId(surveyRecordId);
                    recordDetail.setData(submitProblem.getData());
                    recordDetail.setType(submitProblem.getType());
                    recordDetail.setProblemId(submitProblem.getId());
                    recordDetail.setOptionsId(submitProblem.getOptionsId());
                    recordDetailMapper.insert(recordDetail);
                }
                log.info("答题细节记录完毕: userId:"+userId);
            }
        }.start();
        log.info("得出答题结果 userId："+userId+" 结果："+submitResp);
        return submitResp;
    }

    private void recordFillInResults(Map<String, Integer> result, String surveyRecordId) {
        for (String s : result.keySet()) {
            SurveyResult surveyResult = new SurveyResult();
            surveyResult.setResult(result.get(s));
            surveyResult.setBodyTypeId(s);
            surveyResult.setRecordId(surveyRecordId);
            surveyResultMapper.insert(surveyResult);
        }
    }


}
