package com.zwl.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-20 14:23
 * @Description:
 */
//@Configuration
//public class MongoConfig {
//    @Bean
//    public MongoCustomConversions customConversions() {
//        List<Converter<?, ?>> converterList = new ArrayList<>();
//        converterList.add(new DateToString());
//        converterList.add(new StringToDate());
//        return new MongoCustomConversions(converterList);
//    }
//}