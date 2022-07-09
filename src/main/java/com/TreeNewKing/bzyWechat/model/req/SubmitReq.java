package com.TreeNewKing.bzyWechat.model.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Data
public class SubmitReq {
  @Data
  public static  class Problem {
    private String id;
    private Integer type;
    private String picture;
    private String optionsId;
  }

  @Data
  public static class Info{
    private BigDecimal wight;
    private BigDecimal height;
    private String favoriteTea;
    private int  teaAge;
    private String lifeIn;
    private String growthIn;
    private String professional;
  }
  private List<Problem> problem = new ArrayList<>();


  private Info info;


}

