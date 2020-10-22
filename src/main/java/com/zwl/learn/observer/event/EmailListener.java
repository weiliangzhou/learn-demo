package com.zwl.learn.observer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<ErsxMessage> {
    @Override
    public void onApplicationEvent(ErsxMessage ersxMessage) {
        System.out.println(Thread.currentThread().getName() +"发送邮箱：" + ersxMessage.toString());
    }

}
