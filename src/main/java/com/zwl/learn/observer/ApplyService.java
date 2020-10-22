package com.zwl.learn.observer;

import com.alibaba.fastjson.JSONObject;
import com.zwl.learn.observer.event.ErsxMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
@Slf4j
public class ApplyService {

    @Autowired
    private ErsxSubject ersxSubject;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 开闭原则：对拓展开放、对修改关闭
     * 基于观察者模式：增加通知渠道之后不会对apply修改
     */
    @RequestMapping("/apply")
    public void apply() {
        log.info("1.报名");
        log.info("2.发送站内信");
        log.info("3.发送短信");
        log.info("4.发送Email");
//        sendWebMsg();
//        sendMsg();
//        sendEmail();


//        JSONObject jsonObject = new JSONObject();
//        ersxSubject.notifyObServer(jsonObject);
    }


    @RequestMapping("/test1")
    public void test1() {
        ErsxMessage ersxMessage = new ErsxMessage(this, "二师兄", 30);
        applicationEventPublisher.publishEvent(ersxMessage);

    }


}
