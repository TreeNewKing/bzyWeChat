package com.TreeNewKing.bzyWechat.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

 /**
 * 填写记录详情;
 * @author : http://www.chiner.pro
 * @date : 2022-7-15
 */
@ApiModel(value = "填写记录详情",description = "")
@TableName("record_detail")
@Data
public class RecordDetail implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 填写记录主键 */
    @ApiModelProperty(name = "填写记录主键",notes = "")
    private String recordId ;
    /** 问题主键 */
    @ApiModelProperty(name = "问题主键",notes = "")
    private String problemId ;
    /** 选项主键 */
    @ApiModelProperty(name = "选项主键",notes = "")
    private String optionsId ;
    /** 包含数据 */
    @ApiModelProperty(name = "包含数据",notes = "")
    private String data ;
    /** 问题类型 */
    @ApiModelProperty(name = "问题类型",notes = "")
    private Integer type ;


}