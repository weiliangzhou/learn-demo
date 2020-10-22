package com.zwl.learn.jdk.proxy;

import com.zwl.learn.service.OrderService;
import com.zwl.learn.service.OrderServiceImpl;

/** @ClassName TestProxy @Description @Author 二师兄 @Date 2020-07-15 14:30 @Version V1.0 */
public class TestProxy {
  public static void main(String[] args) {
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    OrderService orderService = new JdkInvocationHandler(new OrderServiceImpl()).getProxy();
    orderService.order();
  }
}
