package com.zwl.learn.observer.event;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum OperateType implements Serializable {
    ADD(1, "新增"),
    UPDATE(2, "更新"),
    DELETE(3, "删除");

    private Integer type;
    private String desc;

    OperateType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static OperateType getByType(Integer type) {
        for (OperateType operateType : OperateType.values()) {
            if (operateType.type.equals(type)) {
                return operateType;
            }

        }
        return null;
    }


}
