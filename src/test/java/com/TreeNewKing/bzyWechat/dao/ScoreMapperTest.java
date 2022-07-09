package com.TreeNewKing.bzyWechat.dao;

import com.TreeNewKing.bzyWechat.model.entity.ScoreTab;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScoreMapperTest {
@Autowired
    ScoreMapper scoreMapper;
    @Test
    void getScoreTable() {
        for (ScoreTab scoreTab : scoreMapper.getScoreTable()) {
            System.out.println(scoreTab);
        }
    }
}