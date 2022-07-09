package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.dao.FeedBackMapper;
import com.TreeNewKing.bzyWechat.model.req.FeedBackInfo;
import com.TreeNewKing.bzyWechat.service.FeedBackService;
import com.TreeNewKing.bzyWechat.service.impl.FeedBackServiceImpl;
import com.TreeNewKing.bzyWechat.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedBackController {
   @Value("${spring.mail.username}")
    private String emailMaker;
   @Autowired
   private FeedBackService feedBackService;

    @PostMapping("/api/feedback")
    public  String feedback(FeedBackInfo feedBackInfo){
        try {
        String email_Receiver=feedBackInfo.getEmail();
        String title="感谢你的反馈";
        String content="我们已经成功收到了您关于本系统关于【"+feedBackInfo.getDescription()+"】的反馈。我们会尽快进行改善和修复。感谢您的支持";
        EmailUtils.sendSimpleMail(emailMaker,email_Receiver,title,content);
        feedBackService.insertFeedBackToDb(feedBackInfo);
        }catch (Exception e){
            return e.getMessage();
        }
        return "success";
    }

}
