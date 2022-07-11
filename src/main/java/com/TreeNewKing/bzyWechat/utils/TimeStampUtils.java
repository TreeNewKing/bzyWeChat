package com.TreeNewKing.bzyWechat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtils {
    public static String getFormateTime(){
        Date date=new Date();
        SimpleDateFormat simpleFormatter=new SimpleDateFormat("yy-MM-dd HH:mm");
        String time = simpleFormatter.format(date);
        return  time;
    }
}
