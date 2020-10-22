package com.zwl.learn.strategy_demo;

import lombok.Getter;


public enum PayType {
    ALI_PAY("ali_pay", "支付宝"),
    WX_PAY("wx_pay", "微信支付"),
    YL_PAY("yl_pay", "银联");

    @Getter
    private String type;
    @Getter
    private String desc;

    PayType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static PayType getByType(String type) {
        for (PayType smsType : PayType.values()) {
            if (smsType.type.equals(type)) {
                return smsType;
            }

        }
        return null;
    }


}
