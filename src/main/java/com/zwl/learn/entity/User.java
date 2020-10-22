package com.zwl.learn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author 二师兄
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends BaseEntity {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;


}
