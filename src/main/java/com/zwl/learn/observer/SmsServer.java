package com.zwl.learn.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class SmsServer implements ObServer {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        System.out.println(Thread.currentThread().getName() + "发送短信");
    }
}
