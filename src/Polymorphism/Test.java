package Polymorphism;

public class Test {
    public Test() {
        int myint = 5;
        method(myint);
    }

    void method(long a){
        System.out.println("long a = [" + a + "]");
    }
    void method(Integer a){
        System.out.println("Integer a = [" + a + "]");
    }
    void method(double a){
        System.out.println("double a = [" + a + "]");
    }
}
