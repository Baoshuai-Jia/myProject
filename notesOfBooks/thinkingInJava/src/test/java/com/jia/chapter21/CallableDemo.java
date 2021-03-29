package com.jia.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> submit = exec.submit(new TaskWithResult(i));
            submit.isDone();//查询任务是否完成
//            submit.get();//获取任务返回结果；任务没完成get()会阻塞
            results.add(submit);
        }
        try {
            for (Future future : results)
                System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            exec.shutdown();

        }

    }
}

class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Result of TaskWithResult : "+id;
    }
}
