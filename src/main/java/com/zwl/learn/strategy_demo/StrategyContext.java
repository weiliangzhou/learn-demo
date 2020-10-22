package com.zwl.learn.strategy_demo;//package com.ersx.demo.strategy_demo;//package com.zwl.learn.strategy_demo.pay;
//
//import cn.hutool.core.util.StrUtil;
//import com.ersx.demo.strategy_demo.pay.PayStrategy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class StrategyContext {
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    public PayStrategy getContextStrategy(String beanId) {
//        if (StrUtil.isBlank(beanId)) {
//            return null;
//        }
//        try {
//            return applicationContext.getBean(beanId, PayStrategy.class);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//}
