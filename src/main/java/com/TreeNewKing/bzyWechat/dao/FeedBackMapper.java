package com.TreeNewKing.bzyWechat.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedBackMapper {

    int insertFeedBackToDb(String email, String title, String description);
}
