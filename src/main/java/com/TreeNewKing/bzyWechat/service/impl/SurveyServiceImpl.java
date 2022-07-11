package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.OptionScoreMapper;
import com.TreeNewKing.bzyWechat.dao.ProblemMapper;
import com.TreeNewKing.bzyWechat.dao.SurveyRecordMapper;
import com.TreeNewKing.bzyWechat.error.AppException;
import com.TreeNewKing.bzyWechat.model.entity.Option;
import com.TreeNewKing.bzyWechat.model.entity.OptionScore;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import com.TreeNewKing.bzyWechat.model.entity.SurveyRecord;
import com.TreeNewKing.bzyWechat.model.req.SubmitProblem;
import com.TreeNewKing.bzyWechat.model.req.SubmitReq;
import com.TreeNewKing.bzyWechat.service.SurveyService;
import com.TreeNewKing.bzyWechat.service.helper.IntegralHelperWithTable;
import com.TreeNewKing.bzyWechat.service.helper.Scorecard;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final ProblemMapper problemMapper;
    private final SurveyRecordMapper surveyRecordMapper;
    private final OptionScoreMapper optionScoreMapper;

    public SurveyServiceImpl(@Autowired ProblemMapper problemMapper,@Autowired SurveyRecordMapper surveyRecordMapper,@Autowired OptionScoreMapper optionScoreMapper) {
        this.problemMapper = problemMapper;
        this.surveyRecordMapper=surveyRecordMapper;
        this.optionScoreMapper=optionScoreMapper;
    }

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
        QueryWrapper<SurveyRecord> surveyRecordQueryWrapper = new QueryWrapper<SurveyRecord>().eq("user_id", userId).orderByDesc("create_time");
        SurveyRecord surveyRecord = surveyRecordMapper.selectOne(surveyRecordQueryWrapper);
        return surveyRecord;
    }

    @Override
    @Transactional
    // 不忘记打开事务
    public void submit(String userId, SubmitReq submitReq) {
        //先存一下 提交记录
        SurveyRecord surveyRecord = new SurveyRecord();
        BeanUtils.copyProperties(submitReq,surveyRecord);
        Date date = new Date();
        surveyRecord.setCreateTime(date);
        surveyRecord.setModifyTime(date);
        surveyRecord.setUserId(userId);
        surveyRecordMapper.insert(surveyRecord);
        String surveyRecordId = surveyRecord.getId();
        //算一下 提交
        List<SubmitProblem> problem = submitReq.getProblem();
        Scorecard scorecard = new Scorecard();
        for (SubmitProblem submitProblem : problem) {
            recordScore(submitProblem,scorecard);
        }

    }
    
    //根据类型积分
    public void recordScore(SubmitProblem submitProblem, Scorecard scorecard){
        switch (submitProblem.getType()){
            case 0:
                
            default:
                //TODO 更多类型
                throw new AppException();
        }
        
    }


    public void  recordScoreWithType0(SubmitProblem submitProblem, Scorecard scorecard){
        IntegralHelperWithTable integralHelperWithTable = new IntegralHelperWithTable();
        integralHelperWithTable.score(submitProblem,scorecard);
    }

    //通过 option_score 当type=0时候
    public IntegralHelperWithTable a(List<OptionScore> list){
        IntegralHelperWithTable table = new IntegralHelperWithTable();
        for (OptionScore optionScore : list) {
            if(optionScore.getType()==0){
                table.build(optionScore);
            }else{
                //TODO 扩展更多得分数与选项的对应关系
            }
        }
        return table;
    }

    @Cacheable("option_scores")
    public List<OptionScore> getAllOptionScores(){
        List<OptionScore> optionScores = optionScoreMapper.selectList(new QueryWrapper<>());
        return optionScores;
    }


}
