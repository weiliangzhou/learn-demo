package com.zwl.learn.observer.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @RequestMapping("/addUser")
    public String addUser() {
        UserActionEvent userActionEvent = new UserActionEvent(this);
        userActionEvent.setOperateType(OperateType.UPDATE);
        applicationEventPublisher.publishEvent(userActionEvent);
        return "ok";
    }

}
