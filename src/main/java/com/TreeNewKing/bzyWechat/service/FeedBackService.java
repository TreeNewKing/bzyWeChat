package com.TreeNewKing.bzyWechat.service;

import com.TreeNewKing.bzyWechat.model.req.FeedBackInfo;

public interface FeedBackService {
    String insertFeedBackToDb(FeedBackInfo feedBackInfo) throws Exception;
}
