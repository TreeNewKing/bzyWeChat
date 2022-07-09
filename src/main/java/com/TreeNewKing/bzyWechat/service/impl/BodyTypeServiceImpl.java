package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.BodyTypeMapper;
import com.TreeNewKing.bzyWechat.model.entity.TeaCommend;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;
import com.TreeNewKing.bzyWechat.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {
@Autowired
  private   BodyTypeMapper bodyTypeMapper;
    @Override
    public List<BodyTypeRespAll> getAllBodyType() {
        List<BodyTypeRespAll>rs=bodyTypeMapper.getAllBodyType();
        return rs;
    }

    @Override
    public TeaCommend getTeaCommendByBodyTypeId(String bodyTypId) {
      TeaCommend teaCommend= bodyTypeMapper.getTeaCommendByBodyTypeId(bodyTypId);
        return teaCommend;
    }
}
