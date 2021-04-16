package com.zwl.learn.task;

import com.sun.management.OperatingSystemMXBean;
import com.zwl.learn.dto.Mask;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class CountTask extends RecursiveTask<List> {
    // 设置最小子任务的阈值
    private static final int taskLimit = 1000;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected List<Mask> compute() {
        List finalResult = new ArrayList();
        boolean taskFlag = (end - start) <= taskLimit;
        if (taskFlag) {
            log.info(Thread.currentThread().getName()+"开始执行分页查询当前start为{}，end为{}", start, end);
            // 子任务足够小了，可以开始执行
            for (int i = start; i <= end; i++) {
                Mask mask = new Mask("esx" + i, "desc" + i);
                finalResult.add(mask);
            }

        } else {
//            log.info("需要拆分：当前start为{}，end为{}",start,end);
            // 子任务还不是足够小，需要进一步分割
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            // 分配任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完成，进行结果的合并
            List leftResult = leftTask.join();
            List rightResult = rightTask.join();
            finalResult.addAll(leftResult);
            finalResult.addAll(rightResult);
        }
//        log.info("当前计算结果为：{}",sumResult);
        return finalResult;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Total RAM：" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
        System.out.println("Available　RAM：" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 计算从1累加到100，应该获取5050
        CountTask myTask = new CountTask(1, 50000);
        ForkJoinTask<List> result = forkJoinPool.submit(myTask);
        if (myTask.isCompletedAbnormally()) {
            log.warn("发生了异常，{}", myTask.getException());
        }
//        List<Mask> masks = result.get();
//        for (Mask mask : masks) {
//            System.out.println(mask);
//        }

//        Optional<List> optionalList = Optional.ofNullable(result.get());
//        optionalList.ifPresent(it->{
//            System.out.println(it+"\\\n");
//        });
    }
}