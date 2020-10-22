package com.zwl.learn.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** @ClassName JdkInvocationHandler @Description @Author 二师兄 @Date 2020-07-15 14:28 @Version V1.0 */
public class JdkInvocationHandler implements InvocationHandler {
  /** 被代理对象 目标对象 */
  private Object target;

  public JdkInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(">>>打印订单日志开始");
    Object result = method.invoke(target, args);
    System.out.println(">>>打印订单日志结束");
    return result;
  }

  public <T> T getProxy() {
    return (T)
        Proxy.newProxyInstance(
            target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
  }
}
