package com.TreeNewKing.bzyWechat.model.req;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;



@Data
@ToString
public class SubmitInfo {
  @JsonProperty("weight")
  private Double weight;

  @JsonProperty("height")
  private Double height;

  @JsonProperty("favoriteTea")
  private String favoriteTea;

  @JsonProperty("teaAge")
  private Integer teaAge;

  @JsonProperty("lifeIn")
  private String lifeIn;

  @JsonProperty("growthIn")
  private String growthIn;

  @JsonProperty("professional")
  private String professional;


}

