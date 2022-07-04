package com.TreeNewKing.bzyWechat.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表;
 * @author : http://www.chiner.pro
 * @date : 2022-7-3
 */
@ApiModel(value = "用户表",description = "")
@TableName("user")
@Data
public class User implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 微信开放ID */
    @ApiModelProperty(name = "微信开放ID",notes = "")
    private String openId ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date modifyTime ;
    /** 用户头像 */
    @ApiModelProperty(name = "用户头像",notes = "")
    private String avatar ;
    /** 是否为管理员 */
    @ApiModelProperty(name = "是否为管理员",notes = "")
    private  Integer isAdmin ;
    @ApiModelProperty(name = "昵称",notes = "")
    private String nickname;

}