package com.TreeNewKing.bzyWechat.model.resp;

import com.TreeNewKing.bzyWechat.model.entity.Option;
import com.TreeNewKing.bzyWechat.model.entity.Problem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProblemBankResp {

    @Data
    private static class option{
        private String id;
        private String description;
    }
    @Data
    private static class problemReturn{
        private String id;
        private String description;
        private Integer type;
        private List<option> options;
    }

    private List<problemReturn> problems;



    public static ProblemBankResp toResp(List<Problem> problems){
        ArrayList<problemReturn> problemReturns = new ArrayList<>();
        for (Problem problem : problems) {
            problemReturn problemReturn = new problemReturn();
            List<Option> options = problem.getOptionList();
            List<option> optionsReturn =new ArrayList<>();
            problem.setOptionList(null);
            for (Option option : options) {
                ProblemBankResp.option optionReturn = new option();
                BeanUtils.copyProperties(option,optionReturn);
                optionsReturn.add(optionReturn);
            }
            BeanUtils.copyProperties(problem,problemReturn);
            problemReturn.setOptions(optionsReturn);
            problemReturns.add(problemReturn);
        }
        ProblemBankResp questionBankResp = new ProblemBankResp();
        questionBankResp.setProblems(problemReturns);
        return questionBankResp;
    }
}
