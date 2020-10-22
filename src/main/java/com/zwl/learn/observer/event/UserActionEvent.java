package com.zwl.learn.observer.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
@ToString
public class UserActionEvent extends ApplicationEvent {
    /**
     * 操作类型
     */
    private OperateType operateType;

    public UserActionEvent(Object source) {
        super(source);
    }
}
