package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.entity.TeaCommend;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;

import java.util.List;

public interface BodyTypeService {
    List<BodyTypeRespAll> getAllBodyType();
    TeaCommend getTeaCommendByBodyTypeId(String bodyTypId);
}
