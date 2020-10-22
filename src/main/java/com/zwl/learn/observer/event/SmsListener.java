package com.zwl.learn.observer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements ApplicationListener<ErsxMessage> {
    @Override
    public void onApplicationEvent(ErsxMessage ersxMessage) {
        System.out.println(Thread.currentThread().getName() +"发送短信：" + ersxMessage.toString());

    }

}
