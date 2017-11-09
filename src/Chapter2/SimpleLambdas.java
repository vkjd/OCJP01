package Chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


/*
    Testing Predicate<T>
 */

public class SimpleLambdas{

    public SimpleLambdas(){
        System.out.println(">>> SimpleLambdas");
        StringBuilder sb = new StringBuilder();
        method1(sb, s -> s.length() > 5);
        System.out.println(sb);
    }

    private void method1(StringBuilder sb, Predicate<String> t){
        List<String> list = Arrays.asList("one", "oneone", "two", "twotwo");
        for(String s : list){
            if(t.test(s)) System.out.println(s);
        }
    }

}
