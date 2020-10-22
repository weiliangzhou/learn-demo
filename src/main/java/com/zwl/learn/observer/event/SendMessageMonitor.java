package com.zwl.learn.observer.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 发送消息监听器
 */
@Component
@Slf4j
public class SendMessageMonitor {

    @Async("asyncExecutor")
    @EventListener(value = SendMessageEvent.class, condition = "#sendMessageEvent.sendType==1 || #sendMessageEvent.sendType==3")
    public void sendMsg(SendMessageEvent sendMessageEvent) {
        log.info("发送短信：：" + sendMessageEvent.toString());
    }

    @Async("asyncExecutor")
    @EventListener(value = SendMessageEvent.class, condition = "#sendMessageEvent.sendType==2 || #sendMessageEvent.sendType==3")
    public void sendEmail(SendMessageEvent sendMessageEvent) {
        log.info("发送邮件：：" + sendMessageEvent.toString());
    }

}
