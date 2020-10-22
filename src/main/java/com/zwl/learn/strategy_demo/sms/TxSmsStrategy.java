package com.zwl.learn.strategy_demo.sms;

import org.springframework.stereotype.Component;


@Component
public class TxSmsStrategy implements SmsStrategy {
    @Override
    public String sendMsg() {
        return "腾讯云发送短信";
    }
}
