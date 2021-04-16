package com.zwl.learn.dto;

import lombok.Data;

@Data
public class People {
    private String name;
    private Integer age;
    private String desc;
    public static People getInstance() {
        People people = new People();
        people.setName("二师兄");
        people.setAge(18);
        people.setDesc("测试专用");
        return people;
    }

}
