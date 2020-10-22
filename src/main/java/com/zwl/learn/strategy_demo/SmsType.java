package com.zwl.learn.strategy_demo;

import lombok.Getter;


public enum SmsType {
    ALI_YUN(1, "阿里云"),
    TX_YUN(2, "腾讯云"),
    HW_YUN(3, "华为云"),
    CHUANG_LAN(4, "创蓝");

    @Getter
    private Integer type;
    @Getter
    private String desc;

    SmsType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SmsType getByType(Integer type) {
        for (SmsType smsType : SmsType.values()) {
            if (smsType.type.equals(type)) {
                return smsType;
            }

        }
        return null;
    }


}
