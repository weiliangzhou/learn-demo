package com.zwl.learn.futurTask;

/**
 * @ClassName ZwlCallable
 * @Description
 * @Author 二师兄
 * @Date 2020-08-19 11:07
 * @Version V1.0
 **/
public interface ZwlCallable<V> {
    V call() throws Exception;
}
