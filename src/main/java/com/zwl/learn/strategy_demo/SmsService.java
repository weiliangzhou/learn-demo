package com.zwl.learn.strategy_demo;

import com.zwl.learn.strategy_demo.sms.SmsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信服务
 */
@RestController
public class SmsService {

    @Autowired
    private StrategysContext strategysContext;

    /**
     * @param smsType 1=腾讯云 2=阿里云 3=华为云 4=创蓝
     * @return
     */
    @RequestMapping("/s/sms")
    public String sms(String smsType) {
//        if (smsType.equals(1)) {
//            //腾讯云
//        } else if (smsType.equals(2)) {
//            //阿里云
//        } else if (smsType.equals(3)) {
//            //华为云
//        } else if (smsType.equals(4)) {
//            //创蓝
//        }

//        SmsType smsTypeData = SmsType.getByType(smsType);
//        switch (smsTypeData){
//            case ALI_YUN:
//                break;
//            case TX_YUN:
//                break;
//            case HW_YUN:
//                break;
//            case CHUANG_LAN:
//                break;
//        }
        SmsStrategy smsStrategy = strategysContext.getContextStrategy(smsType, SmsStrategy.class);
        if (smsStrategy == null) {
            return "支付通道不存在或已关闭";
        }
        return smsStrategy.sendMsg();

    }


}
