package com.TreeNewKing.bzyWechat.service.impl;

import com.TreeNewKing.bzyWechat.dao.FeedBackMapper;
import com.TreeNewKing.bzyWechat.model.req.FeedBackInfo;
import com.TreeNewKing.bzyWechat.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
 @Autowired
   private FeedBackMapper feedBackMapper;
    @Override
    public String insertFeedBackToDb(FeedBackInfo feedBackInfo) throws Exception{
        int rs=feedBackMapper.insertFeedBackToDb(feedBackInfo.getEmail(),feedBackInfo.getTitle(),feedBackInfo.getDescription());
        if (rs!=0)return "success";
        return "false";
    }
}
