package com.zwl.learn.strategy_demo.sms;

import org.springframework.stereotype.Component;

@Component
public class AliSmsStrategy implements SmsStrategy {
    @Override
    public String sendMsg() {
        return "阿里云发送短信";
    }
}
