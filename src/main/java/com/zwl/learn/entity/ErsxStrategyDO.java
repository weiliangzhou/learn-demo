package com.zwl.learn.entity;

import lombok.Data;

@Data
public class ErsxStrategyDO {
    private Long id;
    private String strategyName;
    private String strategyId;
    private String strategyClass;
    private Boolean isDelete;
}
