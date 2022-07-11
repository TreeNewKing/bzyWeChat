package com.TreeNewKing.bzyWechat.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * 问题反馈表;
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@ApiModel(value = "问题反馈表",description = "")
@TableName("feedback")
public class Feedback implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 标题 */
    @ApiModelProperty(name = "标题",notes = "")
    private String title ;
    /** 描述 */
    @ApiModelProperty(name = "描述",notes = "")
    private String description ;
    /** 邮箱 */
    @ApiModelProperty(name = "邮箱",notes = "")
    private String email ;
    /** 用户ID */
    @ApiModelProperty(name = "用户ID",notes = "")
    private String userId ;
    /** 状态;0代表 未处理 1代表处理中 2代表已处理 */
    @ApiModelProperty(name = "状态",notes = "0代表 未处理 1代表处理中 2代表已处理")
    private Integer state ;
    /** 备注 */
    @ApiModelProperty(name = "备注",notes = "")
    private String memo ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date modifyTime ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 标题 */
    public String getTitle(){
        return this.title;
    }
    /** 标题 */
    public void setTitle(String title){
        this.title=title;
    }
    /** 描述 */
    public String getDescription(){
        return this.description;
    }
    /** 描述 */
    public void setDescription(String description){
        this.description=description;
    }
    /** 邮箱 */
    public String getEmail(){
        return this.email;
    }
    /** 邮箱 */
    public void setEmail(String email){
        this.email=email;
    }
    /** 用户ID */
    public String getUserId(){
        return this.userId;
    }
    /** 用户ID */
    public void setUserId(String userId){
        this.userId=userId;
    }
    /** 状态;0代表 未处理 1代表处理中 2代表已处理 */
    public Integer getState(){
        return this.state;
    }
    /** 状态;0代表 未处理 1代表处理中 2代表已处理 */
    public void setState(Integer state){
        this.state=state;
    }
    /** 备注 */
    public String getMemo(){
        return this.memo;
    }
    /** 备注 */
    public void setMemo(String memo){
        this.memo=memo;
    }
    /** 创建时间 */
    public Date getCreateTime(){
        return this.createTime;
    }
    /** 创建时间 */
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    /** 更新时间 */
    public Date getModifyTime(){
        return this.modifyTime;
    }
    /** 更新时间 */
    public void setModifyTime(Date modifyTime){
        this.modifyTime=modifyTime;
    }
}