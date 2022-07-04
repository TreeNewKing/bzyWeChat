package com.TreeNewKing.bzyWechat.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 问题表;
 * @author : http://www.chiner.pro
 * @date : 2022-7-3
 */
@ApiModel(value = "问题表",description = "")
@TableName("problem")
@Data
public class Problem implements Serializable,Cloneable{
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 问题描述 */
    @ApiModelProperty(name = "问题描述",notes = "")
    private String description ;
    /** 问题类型 */
    @ApiModelProperty(name = "问题类型",notes = "")
    private Integer type ;
    /** 是否必填 */
    @ApiModelProperty(name = "是否必填",notes = "")
    private Integer mandatory ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date modifyTime ;
    /** 排序字段 */
    @ApiModelProperty(name = "排序字段",notes = "")
    private Integer orderBy ;


    @TableField(exist = false)
    private List<Option> optionList;
}