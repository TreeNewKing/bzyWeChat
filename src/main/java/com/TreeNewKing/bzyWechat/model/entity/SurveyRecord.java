package com.TreeNewKing.bzyWechat.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class SurveyRecord {
    @ApiModelProperty(name = "主键", notes = "")
    @TableId

    private String id;
    /**
     * 用户ID
     */
    @ApiModelProperty(name = "用户ID", notes = "")
    private String userId;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "创建时间", notes = "")
    private Date createTime;
    /**
     * 是否附带图片
     */
    @ApiModelProperty(name = "是否附带图片", notes = "")
    private Integer hasPicture;
    /**
     * 更新时间
     */
    @ApiModelProperty(name = "更新时间", notes = "")
    private Date modifyTime;
    /**
     * 体重
     */
    @ApiModelProperty(name = "体重", notes = "")
    private Double wight;
    /**
     * 身高
     */
    @ApiModelProperty(name = "身高", notes = "")
    private Double height;
    /**
     * 喜欢喝什么茶
     */
    @ApiModelProperty(name = "喜欢喝什么茶", notes = "")
    private String favoriteTea;
    /**
     * 茶龄
     */
    @ApiModelProperty(name = "茶龄", notes = "")
    private Integer teaAge;
    /**
     * 目前主要生活区
     */
    @ApiModelProperty(name = "目前主要生活区", notes = "")
    private String lifeIn;
    /**
     * 幼年生长地
     */
    @ApiModelProperty(name = "幼年生长地", notes = "")
    private String growthIn;
    /**
     * 职业
     */
    @ApiModelProperty(name = "职业", notes = "")
    private String professional;
}
