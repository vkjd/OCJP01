package Chapter2;

public class SinlgetonPattern {
    public SinlgetonPattern(){
        System.out.println(">>> SinlgetonPattern");
        SingletonTest st = SingletonTest.getInstance();
        System.out.println("st = " + st);
        st = SingletonTest.getInstance();
        System.out.println("st = " + st);
        st = SingletonTest.getInstance();
        System.out.println("st = " + st);
    }
}

class SingletonTest{
    private static volatile SingletonTest instance;
    private int count;

    private SingletonTest(){
        count++;
        System.out.println("count = " + count);
    }

    static SingletonTest getInstance() {
        if(instance == null){
            synchronized (SingletonTest.class) {
                if(instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public int getCount() {
        return count;
    }
}
