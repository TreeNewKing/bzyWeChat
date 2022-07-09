package com.TreeNewKing.bzyWechat.model.resp;

import com.TreeNewKing.bzyWechat.model.entity.TeaCommend;
import lombok.Data;

@Data
public class TeaCommandRespV1 {
private int code;
private String erroMsg;
private TeaCommend data;
}
