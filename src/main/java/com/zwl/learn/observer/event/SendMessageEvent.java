package com.zwl.learn.observer.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
@ToString
public class SendMessageEvent extends ApplicationEvent {

    private String phone;
    private String email;
    private String content;
    /**
     * 1= 只发短信
     * 2= 只发邮件
     * 3= 短信、邮件都发
     */
    private Integer sendType;

    public SendMessageEvent(Object source) {
        super(source);
    }
}
