package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.ScoreTab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {
    List<ScoreTab> getScoreTable();
}
