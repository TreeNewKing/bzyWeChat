package com.TreeNewKing.bzyWechat.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

 /**
 * 填写结果;
 * @author : http://www.chiner.pro
 * @date : 2022-7-14
 */
@ApiModel(value = "填写结果",description = "")
@TableName("survey_result")
@Data
public class SurveyResult implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 填写记录ID */
    @ApiModelProperty(name = "填写记录ID",notes = "")
    private String recordId ;
    /** 体质类型ID */
    @ApiModelProperty(name = "体质类型ID",notes = "")
    private String bodyTypeId ;
    /** 填写结果 */
    @ApiModelProperty(name = "填写结果",notes = "")
    private Integer result ;



}