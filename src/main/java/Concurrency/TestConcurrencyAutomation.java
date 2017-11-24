package Concurrency;

import javafx.concurrent.ScheduledService;

import java.time.temporal.ChronoField;
import java.util.concurrent.*;

public class TestConcurrencyAutomation {
    public TestConcurrencyAutomation() {
        System.out.println("Greetings, Executor! En taro Adun!");
        new SingleExecutor();
    }
}

class SingleExecutor{
    public SingleExecutor() {
//        method1();
//        method2();
//        methodScheduled();
//        methodPool();
        processors();
    }

    void processors(){
        System.out.println("wow such runtime many processors "+Runtime.getRuntime().availableProcessors());
    }

    void methodPool(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Runnable task1 = () -> System.out.println("1");
        Runnable task5 = () -> System.out.println(" 2");
        Runnable task2 = () -> System.out.println("  3");
        Runnable task3 = () -> System.out.println("   4");
        Runnable task4 = () -> System.out.println("    5");
        pool.scheduleWithFixedDelay(task1, 1, 1, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(task2, 1, 1, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(task3, 1, 1, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(task4, 1, 1, TimeUnit.SECONDS);
        pool.scheduleWithFixedDelay(task5, 1, 1, TimeUnit.SECONDS);
    }

    void methodScheduled(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(()->System.out.println("Scheduled message"), 1, 1, TimeUnit.SECONDS);
    }

    void method2(){
        int number = 1;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(() -> number*2);
        System.out.println("future = " + future);
        try {
            System.out.println("future = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

    void method1(){
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("it begins");
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            executorService.execute(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Printint recod : " + i);
                }
            });
            executorService.execute(() -> System.out.println("Printing zoo inventory"));

            System.out.println("End");
        }finally {
            if(executorService != null)executorService.shutdown();
        }
    }
}

class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 5000; i++) CheckResults.counter++;
        }).start();
        while (CheckResults.counter < 1000) {
            System.out.println("Not reached yet");
            Thread.sleep(1); // 1 SECOND
        }
        System.out.println("Reached!");
    }
}