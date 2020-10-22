package com.zwl.learn;

import lombok.Data;

@Data
public class Strategy {
  private Long id;
  private String strategyName;
  private String strategyId;
  private String strategyClass;
  private Boolean isDelete;
}
