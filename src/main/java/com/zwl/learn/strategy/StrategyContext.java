//package com.zwl.learn.strategy;
//
//import com.zwl.learn.Strategy;
//import com.zwl.learn.dao.StrategyMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
///**
// * @ClassName 通用策略模式 @Description @Author 二师兄 @Date 2020-07-03 14:25 @Version V1.0
// */
//@Component
//public class StrategyContext {
//    @Autowired
//    private ApplicationContext applicationContext;
//    @Autowired
//    private StrategyMapper strategyMapper;
//
//    public <T> T getStrategy(String strategyId, Class<T> clazz) {
//        if (StringUtils.isEmpty(strategyId)) {
//            return null;
//        }
//        Strategy strategy = strategyMapper.getByStrategyId(strategyId);
//        if (strategy == null) {
//            return null;
//        }
//        String strategyClass = strategy.getStrategyClass();
//        try {
//            return applicationContext.getBean(strategyClass, clazz);
//        } catch (Exception e) {
//            return null;
//        }
//
//    }
//}
