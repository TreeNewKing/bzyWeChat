package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.TeaCommend;
import com.TreeNewKing.bzyWechat.model.resp.BodyTypeRespAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BodyTypeMapper {
    List<BodyTypeRespAll> getAllBodyType();

    TeaCommend getTeaCommendByBodyTypeId(String bodyTypId);
}
