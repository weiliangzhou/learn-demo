package com.zwl.learn.service;

/** @ClassName OrderServiceProxy @Description @Author 二师兄 @Date 2020-07-15 14:23 @Version V1.0 */
public class OrderServiceProxy extends OrderServiceImpl {

  @Override
  public void order() {
    System.out.println("执行之前。。。。。");
    super.order();
    System.out.println("执行之后。。。。。");
  }
}
