package com.zwl.learn.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-20 14:23
 * @Description:
 */
// Direction: MongoDB -> Java
//@ReadingConverter
//public class StringToDate implements Converter<String, LocalDateTime> {
//    @Override
//    public LocalDateTime convert(String source) {
//        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
//    }
//}
