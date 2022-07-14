package com.TreeNewKing.bzyWechat.model.resp;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class SubmitResp {
    @Data
    @ToString
    public static class  SubmitItem{
        String id;
        String name;
        Integer result;
    }
    private List<SubmitItem> list=new ArrayList<>();




    public void build(String id,String name,Integer result){
        SubmitItem submitItem = new SubmitItem();
        submitItem.setId(id);
        submitItem.setName(name);
        submitItem.setResult(result);
        list.add(submitItem);
    }
}
