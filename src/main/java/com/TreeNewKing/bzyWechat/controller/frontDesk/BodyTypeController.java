package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;
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
}
