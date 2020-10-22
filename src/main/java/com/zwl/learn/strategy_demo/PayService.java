package com.zwl.learn.strategy_demo;

import com.zwl.learn.strategy_demo.pay.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信服务
 */
@RestController
public class PayService {

    @Autowired
    private StrategysContext strategysContext;

    /**
     * @param payType ali_pay=支付宝 wx_pay=微信支付 yl_pay=银联
     * @return
     */
    @RequestMapping("/s/pay")
    public String pay(String payType) {
        //普通写法
//        if (smsType.equals("ali_pay")) {
//            //支付宝
//        } else if (smsType.equals("wx_pay")) {
//            //微信支付
//        } else if (smsType.equals("yl_pay")) {
//            //银联
//        }
        //中级写法
//        PayType payTypeData = PayType.getByType(payType);
//        switch (payTypeData) {
//            case ALI_PAY:
//                break;
//            case WX_PAY:
//                break;
//            case YL_PAY:
//                break;
//        }
//        高级写法 工厂模式+策略模式（不推荐）
//        PayStrategy contextStrategy = StrategyFactory.getContextStrategy(payType);
//        if (contextStrategy == null) {
//            return "支付通道不存在或已关闭";
//        }
//        return contextStrategy.success();
        //高级写法 工厂模式（通过spring容器改造）+策略模式（推荐）
//        PayStrategy contextStrategy = strategyContext.getContextStrategy(payType);
//        if (contextStrategy == null) {
//            return "支付通道不存在或已关闭";
//        }
//        return contextStrategy.success();
        //架构写法  数据库+多行为策略模式（推荐）
        PayStrategy contextStrategy = strategysContext.getContextStrategy(payType, PayStrategy.class);
        if (contextStrategy == null) {
            return "支付通道不存在或已关闭";
        }
        return contextStrategy.success();

//        return null;
    }


}
