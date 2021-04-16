package com.zwl.learn.dto;

import lombok.Data;

@Data
public class PPeople {
    private People people = People.getInstance();
    private String desc;
}
