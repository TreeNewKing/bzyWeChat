package com.TreeNewKing.bzyWechat.controller.frontDesk;

import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.error.AppException;
import com.TreeNewKing.bzyWechat.model.entity.Feedback;
import com.TreeNewKing.bzyWechat.model.req.FeedbackReq;
import com.TreeNewKing.bzyWechat.service.FeedbackService;
import com.TreeNewKing.bzyWechat.utils.EmailUtils;
import com.TreeNewKing.bzyWechat.utils.JWTUtils;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
@Log4j2
public class FeedBackController {
    @Value("${spring.mail.username}")
    private String emailMaker;
    @Autowired
    private FeedbackService feedBackService;

    @PostMapping()
    public ApiResponse feedback(@RequestHeader("Authorization") String token, @RequestBody FeedbackReq feedBackReq) {
        String email_Receiver = feedBackReq.getEmail();
        String title = "感谢你的反馈";
        String content = "我们已经成功收到了您关于本系统关于【" + feedBackReq.getDescription() + "】的反馈。我们会尽快进行改善和修复。感谢您的支持";
        try {
            JWTUtils.JWTDto jwtDto = JWTUtils.getJWTDto(token);
            EmailUtils.sendSimpleMail(emailMaker, email_Receiver, title, content);
            Feedback feedback = new Feedback();
            BeanUtils.copyProperties(feedBackReq, feedback);
            feedback.setUserId(jwtDto.getUserId());
            feedBackService.insertFeedbackToDb(feedback);
        } catch (Exception e) {
            log.error(e.toString());
            throw new AppException();
        }
        return ApiResponse.ok();
    }

}
