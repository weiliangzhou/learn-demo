package com.zwl.learn.observer;

import com.alibaba.fastjson.JSONObject;

public interface ObServer {
    void sendMsg(JSONObject jsonObject);
}
