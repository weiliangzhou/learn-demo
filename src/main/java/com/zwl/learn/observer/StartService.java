package com.zwl.learn.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StartService implements ApplicationRunner {
    @Autowired
    private ErsxSubject ersxSubject;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, ObServer> beans = applicationContext.getBeansOfType(ObServer.class);
        for (String beanId : beans.keySet()) {
            ObServer obServer = beans.get(beanId);
            ersxSubject.addObServer(obServer);
        }
    }

}
