package com.zwl.learn.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ErsxSubject {
    @Autowired
    private SmsServer smsServer;
    @Autowired
    private EmailServer emailServer;


    private List<ObServer> listObServer = new ArrayList<>();
    private ExecutorService executorService;

    public ErsxSubject() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * 新增server
     */

    public void addObServer(ObServer obServer) {
        listObServer.add(obServer);

    }

    /**
     * 通知给所有的观察者
     */
    public void notifyObServer(JSONObject jsonObject) {
        for (ObServer obServer : listObServer) {
            executorService.execute(() -> {
                obServer.sendMsg(jsonObject);

            });
        }


    }
}
