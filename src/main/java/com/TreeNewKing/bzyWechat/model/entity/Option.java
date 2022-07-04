package com.TreeNewKing.bzyWechat.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "选项表",description = "")
@TableName("option")
@Data
public class Option implements Serializable,Cloneable{
    @ApiModelProperty(name = "主键",notes = "")
    @TableId
    private String id ;
    /** 对应所得分项 */
    @ApiModelProperty(name = "对应所得分项",notes = "")
    private String bodyTypeId ;
    /** 问题ID */
    @ApiModelProperty(name = "问题ID",notes = "")
    private String problemId ;
    /** 描述 */
    @ApiModelProperty(name = "描述",notes = "")
    private String description ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private Date createTime ;
    /** 更新时间 */
    @ApiModelProperty(name = "更新时间",notes = "")
    private Date modifyTime ;
    /** 排序字段 */
    @ApiModelProperty(name = "排序字段",notes = "")
    private Integer orderBy ;

    public Option(String id, String description, Integer orderBy) {
        this.id = id;
        this.description = description;
        this.orderBy = orderBy;
    }

    public static List<Option> simpleOption;
    static {
        //TODO 简单响应 后续可以放在数据库里头
        simpleOption=new ArrayList<>();
        simpleOption.add(new Option("1","没有(根本不/从来没有)",1));
        simpleOption.add(new Option("2","很少(有一点/偶尔)",2));
        simpleOption.add(new Option("3","有时(有些/少数时间)",3));
        simpleOption.add(new Option("4","经常(相当多数时间)",4));
        simpleOption.add(new Option("5","总是(非常每天)",5));
    }
}