package com.TreeNewKing.bzyWechat.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

 /**
 * 茶推荐表;
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@ApiModel(value = "茶推荐表",description = "")
@TableName("tea_recommend")
public class TeaRecommend implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 体质类型ID */
    @ApiModelProperty(name = "体质类型ID",notes = "")
    private String bodyTypeId ;
    /** 饮茶建议 */
    @ApiModelProperty(name = "饮茶建议",notes = "")
    private String drinkingAdvice ;
    /** 上午推荐茶 */
    @ApiModelProperty(name = "上午推荐茶",notes = "")
    private String morningTea ;
    /** 下午推荐茶 */
    @ApiModelProperty(name = "下午推荐茶",notes = "")
    private String afternoonTea ;
    /** 傍晚推荐茶 */
    @ApiModelProperty(name = "傍晚推荐茶",notes = "")
    private String evenTea ;
    /** 春季推荐茶 */
    @ApiModelProperty(name = "春季推荐茶",notes = "")
    private String springTea ;
    /** 夏季推荐茶 */
    @ApiModelProperty(name = "夏季推荐茶",notes = "")
    private String summerTea ;
    /** 秋季推荐茶 */
    @ApiModelProperty(name = "秋季推荐茶",notes = "")
    private String autumnTea ;
    /** 冬季推荐茶 */
    @ApiModelProperty(name = "冬季推荐茶",notes = "")
    private String winterTea ;
    /** 特别推荐茶 */
    @ApiModelProperty(name = "特别推荐茶",notes = "")
    private String specialTea ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 体质类型ID */
    public String getBodyTypeId(){
        return this.bodyTypeId;
    }
    /** 体质类型ID */
    public void setBodyTypeId(String bodyTypeId){
        this.bodyTypeId=bodyTypeId;
    }
    /** 饮茶建议 */
    public String getDrinkingAdvice(){
        return this.drinkingAdvice;
    }
    /** 饮茶建议 */
    public void setDrinkingAdvice(String drinkingAdvice){
        this.drinkingAdvice=drinkingAdvice;
    }
    /** 上午推荐茶 */
    public String getMorningTea(){
        return this.morningTea;
    }
    /** 上午推荐茶 */
    public void setMorningTea(String morningTea){
        this.morningTea=morningTea;
    }
    /** 下午推荐茶 */
    public String getAfternoonTea(){
        return this.afternoonTea;
    }
    /** 下午推荐茶 */
    public void setAfternoonTea(String afternoonTea){
        this.afternoonTea=afternoonTea;
    }
    /** 傍晚推荐茶 */
    public String getEvenTea(){
        return this.evenTea;
    }
    /** 傍晚推荐茶 */
    public void setEvenTea(String evenTea){
        this.evenTea=evenTea;
    }
    /** 春季推荐茶 */
    public String getSpringTea(){
        return this.springTea;
    }
    /** 春季推荐茶 */
    public void setSpringTea(String springTea){
        this.springTea=springTea;
    }
    /** 夏季推荐茶 */
    public String getSummerTea(){
        return this.summerTea;
    }
    /** 夏季推荐茶 */
    public void setSummerTea(String summerTea){
        this.summerTea=summerTea;
    }
    /** 秋季推荐茶 */
    public String getAutumnTea(){
        return this.autumnTea;
    }
    /** 秋季推荐茶 */
    public void setAutumnTea(String autumnTea){
        this.autumnTea=autumnTea;
    }
    /** 冬季推荐茶 */
    public String getWinterTea(){
        return this.winterTea;
    }
    /** 冬季推荐茶 */
    public void setWinterTea(String winterTea){
        this.winterTea=winterTea;
    }
    /** 特别推荐茶 */
    public String getSpecialTea(){
        return this.specialTea;
    }
    /** 特别推荐茶 */
    public void setSpecialTea(String specialTea){
        this.specialTea=specialTea;
    }
}