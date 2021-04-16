package com.zwl.learn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaskDTO {
    /**
     * 品牌
     */
    private String brandTemp;
    /**
     * 类型
     */
    private String typeTemp;
}
