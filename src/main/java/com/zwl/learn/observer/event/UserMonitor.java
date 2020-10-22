package com.zwl.learn.observer.event;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserMonitor {
    @Async
    @EventListener(value = UserActionEvent.class, condition = "#event.operateType.type==1")
    public void addUserActionEvent(UserActionEvent event) {
        log.info("监听新增用户操作");
    }

    @Async
    @EventListener(value = UserActionEvent.class, condition = "#event.operateType.type==2")
    public void updateUserActionEvent(UserActionEvent event) {
        log.info("监听更新用户操作");
    }

    @Async
    @EventListener(value = UserActionEvent.class, condition = "#event.operateType.type==3")
    public void deleteUserActionEvent(UserActionEvent event) {
        log.info("监听删除用户操作");
    }

    @Async
    @EventListener(value = UserActionEvent.class)
    public void userActionEvent(UserActionEvent event) {
        log.info("监听用户操作");
    }
}
