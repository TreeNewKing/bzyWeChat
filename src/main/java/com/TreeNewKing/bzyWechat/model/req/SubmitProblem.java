package com.TreeNewKing.bzyWechat.model.req;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class SubmitProblem {
  @JsonProperty("id")
  private String id;

  @JsonProperty("type")
  private Integer type;

  @JsonProperty("data")
  private String data;

  @JsonProperty("options_id")
  private String optionsId;

}

