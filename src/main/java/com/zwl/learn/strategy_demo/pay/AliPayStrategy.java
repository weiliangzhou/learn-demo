package com.zwl.learn.strategy_demo.pay;

import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String success() {
        return "支付宝支付";
    }
}
