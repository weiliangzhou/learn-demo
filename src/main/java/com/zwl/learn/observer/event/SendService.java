package com.zwl.learn.observer.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/t/send")
    public void send() {
        SendMessageEvent sendMessageEvent = new SendMessageEvent(this);
        sendMessageEvent.setPhone("17682333183");
        sendMessageEvent.setEmail("382308664@qq.com");
        sendMessageEvent.setContent("二师兄是靓仔");
        sendMessageEvent.setSendType(1);
        applicationEventPublisher.publishEvent(sendMessageEvent);
    }
}
