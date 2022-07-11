package com.TreeNewKing.bzyWechat.model.req;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;



@Data
public class SubmitInfo {
  @JsonProperty("wight")
  private BigDecimal wight;

  @JsonProperty("height")
  private BigDecimal height;

  @JsonProperty("favoriteTea")
  private String favoriteTea;

  @JsonProperty("teaAge")
  private String teaAge;

  @JsonProperty("lifeIn")
  private String lifeIn;

  @JsonProperty("growthIn")
  private String growthIn;

  @JsonProperty("professional")
  private String professional;


}

