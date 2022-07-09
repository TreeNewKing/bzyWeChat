package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.model.entity.TeaCommend;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;
import com.TreeNewKing.bzyWechat.model.resp.TeaCommandRespV1;
import com.TreeNewKing.bzyWechat.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BodyTypeController {
    @Autowired
    private BodyTypeService bodyTypeService;
    @GetMapping("/api/bodyType")
    public List<BodyTypeRespAll> getAllBodyType(){
        List<BodyTypeRespAll>rs=bodyTypeService.getAllBodyType();
        return  rs;
}
    @GetMapping("/api/teaRecommend")
   public TeaCommandRespV1 getTeaCommendByBodyTypeId(String bodyType_id){
        TeaCommend teaCommend=null;
        TeaCommandRespV1 rs=null;
        try{
        teaCommend=bodyTypeService.getTeaCommendByBodyTypeId(bodyType_id);
        rs=new  TeaCommandRespV1();
        rs.setCode(200);
        rs.setData(teaCommend);
        }catch (Exception e){//捕获到异常返回异常信息
            rs.setErroMsg(e.getMessage());
            return rs;
        }
        return  rs;
    }
}
