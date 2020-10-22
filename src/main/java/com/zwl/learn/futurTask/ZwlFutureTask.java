package com.zwl.learn.futurTask;

import java.util.concurrent.locks.LockSupport;

/** @ClassName ZwlFutureTask @Description @Author 二师兄 @Date 2020-08-19 11:13 @Version V1.0 */
public class ZwlFutureTask<V> implements Runnable {
  private ZwlCallable<V> zwlCallable;

  private V result;

  private Thread curThread;

  public ZwlFutureTask(ZwlCallable<V> zwlCallable) {
    this.zwlCallable = zwlCallable;
  }

  @Override
  public void run() {
    try {
      result = zwlCallable.call();
      LockSupport.unpark(curThread);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public V get() {
    if (result != null) {
      return result;
    }
    curThread = Thread.currentThread();
    LockSupport.park(curThread);
    return result;
  }
}
