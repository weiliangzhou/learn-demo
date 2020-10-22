package com.zwl.learn.strategy_demo.pay;

import org.springframework.stereotype.Component;

@Component
public class YLPayStrategy implements PayStrategy {
    @Override
    public String success() {
        return "银联支付";
    }
}
