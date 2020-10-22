package com.zwl.learn.strategy_demo;//package com.ersx.demo.strategy_demo;
//
//import com.ersx.demo.strategy_demo.pay.AliPayStrategy;
//import com.ersx.demo.strategy_demo.pay.PayStrategy;
//import com.ersx.demo.strategy_demo.pay.WxPayStrategy;
//import com.ersx.demo.strategy_demo.pay.YLPayStrategy;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class StrategyFactory {
//    private static Map<String, PayStrategy> smsStrategys = new ConcurrentHashMap();
//
//    static {
//        smsStrategys.put("ali_pay", new AliPayStrategy());
//        smsStrategys.put("wx_pay", new WxPayStrategy());
//        smsStrategys.put("yl_pay", new YLPayStrategy());
//    }
//
//    public static PayStrategy getContextStrategy(String beanId) {
//        return smsStrategys.get(beanId);
//    }
//
//
//}
