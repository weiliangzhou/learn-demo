package com.zwl.learn.cglib.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibMethodInterceptor
 * @Description
 * @Author 二师兄
 * @Date 2020-07-15 15:21
 * @Version V1.0
 * cglib优点: jdk动态代理必须要实现接口，这时候cglib就是最好的选择并且cglib会比jdk生成代理类要快 底层通过asm字节码技术
 *      缺点: 不能代理目标对象的final方法
 */
public class CglibMethodInterceptor implements MethodInterceptor {
  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("cglib日志收集开始。。。。");
    Object result = methodProxy.invokeSuper(o, args);
    System.out.println("cglib日志收集结束。。。。");
    return result;
  }
}
