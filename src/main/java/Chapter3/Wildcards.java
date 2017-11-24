package Chapter3;

/*
    Wildcards & Bounds
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
    public Wildcards(){
        System.out.println(">>> Wildcards");
        WildcardTest wt = new WildcardTest();
        wt.method1();
        wt.method45();
    }
}

interface CanSwim{

}

class Fish implements CanSwim{

    void testone(){
        List<CanSwim> list = new ArrayList<>();
        List<Fish> list2 = new ArrayList<>();
        testMethod(list);
//        testMethod(list2);

        testMethod2(list);
        testMethod2(list2);

        List<? super Middle> list3 = new ArrayList<TopClass>();
        List<? super Middle> list4 = new ArrayList<>();
//        List<? super Middle> list5 = new ArrayList<SubClass>();
    }

    private void testMethod(List<CanSwim> list){

    }

    private void testMethod2(List<? extends CanSwim> list){

    }

    class TopClass{

    }

    class Middle extends TopClass{

    }

    class SubClass extends Middle{

    }
}

class WildcardTest{
    void method1(){
        List<?> listOne = new ArrayList<String>();
        List<? extends Exception> listTwo = new ArrayList<RuntimeException>();
        List<? super Exception> listThree = new ArrayList<Object>();
        List<RuntimeException> listFour = new ArrayList<>();
//        List<Object> listFour = new ArrayList<String>();
//        listOne.add(new String("test"));
//        listOne.add(new Object());
//        listOne.add("test");

        RuntimeException re = new RuntimeException("test");
//        listTwo.add(re);
        listFour.add(re);
//        listTwo.add(new RuntimeException());
//        listTwo.add(new Exception());

//        listThree.add(new Object());
        listThree.add(new RuntimeException());
        listThree.add(new Exception());
        listThree.add(new NullPointerException());
//        listThree.add(new Integer(4));

        List<? super Number> listFive = new ArrayList<>();
        listFive.add(4);
        listFive.add(3.4);
//        listFive.add(new Object());

        method2(listOne);
        method2(listThree);
        method2(listThree);

//        method3(listOne);
        method3(listTwo);
//        method3(listThree);

//        method4(listOne);
//        method4(listTwo);
        method4(listThree);
    }

    private void method2(List<?> listOne){

    }
    private void method3(List<? extends Exception> listTwo){

    }
    private void method4(List<? super Exception> listThree){

    }

    void method45(){
        List<Double> list = Arrays.asList(2.9, 5.9, 3.9);
        method5(list);
    }

    private void method5(List<? extends Number> list){
        long sum = 0;
        for(Number n : list){
            sum += n.longValue();
        }
        System.out.println("sum = " + sum);
    }
}