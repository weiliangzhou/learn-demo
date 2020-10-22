package com.zwl.learn.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 基础父类测试
 * </p>
 *
 * @author 二师兄
 * @since 2018-08-11
 */
@Data
public class BaseEntity implements Serializable {
  @TableId(type = IdType.AUTO)
  private Long id;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date modifyTime;
  @Version
  private Integer version;
  @TableLogic
  private Boolean deleted;

}
