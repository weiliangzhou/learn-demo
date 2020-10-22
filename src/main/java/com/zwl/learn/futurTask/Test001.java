package com.zwl.learn.futurTask;

/** @ClassName ZwlFurtureTask @Description @Author 二师兄 @Date 2020-08-19 10:35 @Version V1.0 */
public class Test001 implements ZwlCallable<String> {
  @Override
  public String call() throws Exception {
    Thread.sleep(3000);
    String name = Thread.currentThread().getName();
    System.out.println(name + "::执行");
    return "执行成功";
  }
}
