package com.TreeNewKing.bzyWechat.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

 /**
 * 选项与对应分数的对应;
 * @author : http://www.chiner.pro
 * @date : 2022-7-11
 */
@ApiModel(value = "选项与对应分数的对应",description = "")
@TableName("option_score")
@Data
public class OptionScore implements Serializable,Cloneable{
    /** 主键 */
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 问题所对应ID或者选项所对应ID */
    @ApiModelProperty(name = "问题所对应ID或者选项所对应ID",notes = "")
    private String itemId ;
    /** 体质类型对应ID */
    @ApiModelProperty(name = "体质类型对应ID",notes = "")
    private String bodyTypeId ;
    /** 分数 */
    @ApiModelProperty(name = "分数",notes = "")
    private Integer score ;
    /** 类型;当type为0时 item_id 为问题ID 当type为1时 item_id为选项ID */
    @ApiModelProperty(name = "类型",notes = "当type为0时 item_id 为问题ID 当type为1时 item_id为选项ID")
    private Integer type ;

}