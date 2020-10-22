package com.zwl.learn.hbase.config;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-22 10:30
 * @Description:
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "hbase")
public class HbaseProperties {
    private Map<String, String> config;
    public Map<String, String> getConfig() {
        return config;
    }
    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
