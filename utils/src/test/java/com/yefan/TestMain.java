package com.yefan;

import java.util.concurrent.*;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/15
 */

public class TestMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new AddNumberTask());
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        Integer integer = future.get();
        System.out.println(integer);
// 关闭线程池
        if (executor != null)
            executor.shutdown();
    }

}
class AddNumberTask implements Callable<Integer> {

    public AddNumberTask() {

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("####AddNumberTask###call()");
        Thread.sleep(5000);
        return 5000;
    }

}

