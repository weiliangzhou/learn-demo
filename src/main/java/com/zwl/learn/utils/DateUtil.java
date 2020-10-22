package com.zwl.learn.utils;

/**
 * @Auther: 二师兄
 * @Date: 2020-10-20 11:10
 * @Description:
 */

import cn.hutool.core.util.RandomUtil;

import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    /**
     * 生成随机时间
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static LocalDateTime randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return LocalDateTime.ofInstant(Instant.ofEpochMilli(date), ZoneId.systemDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime randomDate = randomDate("2019-04-20", "2020-10-01");
//        System.out.println(formatter.format(randomDate));

        String randomString = RandomUtil.randomString(8);
        double randomDouble = RandomUtil.randomDouble(2,2, RoundingMode.HALF_UP);
        long randomLong = RandomUtil.randomLong(8);
        int randomInt = RandomUtil.randomInt(8);

        System.out.println(randomString);
        System.out.println(randomDouble);
        System.out.println(randomLong);
        System.out.println(randomInt);

    }
}
