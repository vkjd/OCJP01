package Concurrency;

public class TestConcurrent {
    public TestConcurrent(){
//        method1();
        new TestConcurrencyAutomation();
    }

    void method1(){
        System.out.println("implementing...");
        for (int i = 0; i < 5; i++) {
            new Thread(new PrintData(i)).start();
        }
        System.out.println("extending...");
        for (int i = 0; i < 5; i++) {
            new PrintReverse(i).start();
        }
        System.out.println("finishing...");
    }
}

class PrintReverse extends Thread{
    int myid;

    public PrintReverse(int myid) {
        this.myid = myid;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("E myid = " + myid+" i = "+i);;
        }
    }
}

class PrintData implements Runnable{
    int id;
    public PrintData(int i) {
        id = i;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I id = "+id+" i = " + i);
        }
    }
}