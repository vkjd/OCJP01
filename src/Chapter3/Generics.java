package Chapter3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Generics {
    public Generics(){
        System.out.println(">>> Generics");
        GenericClass<Integer> gc = new GenericClass<>();
        Bird b = new Bird();
        Double bd = b.returnStuff(43.44);
        System.out.println("bd = "+bd);
        bd = b.returnStuff(42.44);
        System.out.println("bd = "+bd);
    }
}

class GenericClass<T>{
    private List<T> list = new ArrayList<>();

    T method1(){
        return null;
    }

    void add(T stuff){
        list.add(stuff);
    }
}

class Bird implements Flying<Integer>{
    public Integer getSpeed(){
        return 50;
    }

    <U> U returnStuff(U u) {
        if (u == null) {
            return null;
        } else {return u;}
    }
}

interface Flying<T extends Number>{
    T getSpeed();
}
