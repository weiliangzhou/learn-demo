package com.zwl.learn.strategy_demo;

import cn.hutool.core.util.StrUtil;
import com.zwl.learn.dao.StrategyMapper;
import com.zwl.learn.entity.ErsxStrategyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class StrategysContext {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StrategyMapper strategyMapper;

    public <T> T getContextStrategy(String beanId, Class<T> t) {
        if (StrUtil.isBlank(beanId)) {
            return null;
        }
        //通过数据库，查询当前策略
        ErsxStrategyDO ersxStrategyDO = strategyMapper.getByStrategyId(beanId,"123");
        if (ersxStrategyDO == null) {
            return null;
        }
        String strategyClass = ersxStrategyDO.getStrategyClass();
        if (StrUtil.isBlank(strategyClass)) {
            return null;
        }
        return applicationContext.getBean(strategyClass, t);
    }

}
