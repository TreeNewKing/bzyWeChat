package com.TreeNewKing.bzyWechat.middleware;


import com.TreeNewKing.bzyWechat.config.ApiResponse;
import com.TreeNewKing.bzyWechat.error.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler({AppException.class})
    public ApiResponse Exception(AppException exception){
        return ApiResponse.error(exception.getMessage());
    }



}
