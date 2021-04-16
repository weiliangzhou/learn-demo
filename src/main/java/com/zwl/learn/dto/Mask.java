package com.zwl.learn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mask {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 类型
     */
    private String type;
}
