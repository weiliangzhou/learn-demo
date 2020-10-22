package com.zwl.learn.strategy_demo.sms;

import org.springframework.stereotype.Component;

@Component
public class HwSmsStrategy implements SmsStrategy {
    @Override
    public String sendMsg() {
        return "华为云发送短信";
    }
}
