package com.TreeNewKing.bzyWechat.model.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

public class BodyTypeResult {
   private int sequence;
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 名称 */
    @ApiModelProperty(name = "名称",notes = "")
    @TableField("`name`")
    private String name ;
    /** 描述 */
    @ApiModelProperty(name = "描述",notes = "")
    @TableField("`describe`")
    private String describe ;

    @ApiModelProperty(name = "结果",notes = "")
    private String result;
    /** 所含图片 */
    @ApiModelProperty(name = "所含图片",notes = "")
    private String picture ;
    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 名称 */
    public String getName(){
        return this.name;
    }
    /** 名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 描述 */
    public String getDescribe(){
        return this.describe;
    }
    /** 描述 */
    public void setDescribe(String describe){
        this.describe=describe;
    }
    /** 所含图片 */
    public String getPicture(){
        return this.picture;
    }
    /** 所含图片 */
    public void setPicture(String picture){
        this.picture=picture;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getResult() {
        return result;
    }

    public int getSequence() {
        return sequence;
    }
}
