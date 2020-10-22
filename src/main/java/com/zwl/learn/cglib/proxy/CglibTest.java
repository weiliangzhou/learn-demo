package com.zwl.learn.cglib.proxy;

import com.zwl.learn.service.OrderServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/** @ClassName CglibTest @Description @Author 二师兄 @Date 2020-07-15 15:14 @Version V1.0 */
public class CglibTest {
  public static void main(String[] args) {
    CglibMethodInterceptor interceptor = new CglibMethodInterceptor();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(OrderServiceImpl.class);
    enhancer.setCallback(interceptor);
    OrderServiceImpl orderService = (OrderServiceImpl) enhancer.create();
    orderService.order();
  }
}
