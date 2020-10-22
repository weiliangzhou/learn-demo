package com.zwl.learn.strategy_demo.pay;

import org.springframework.stereotype.Component;

@Component
public class WxPayStrategy implements PayStrategy {
    @Override
    public String success() {
        return "微信支付";
    }
}
