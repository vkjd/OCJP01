package Chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparison {
    public Comparison() {
        System.out.println(">>> Comparison");
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck(5, "five"));
        ducks.add(new Duck(1, "one"));
        ducks.add(new Duck(10, "ten"));
        ducks.add(new Duck(10, "Tenten"));
        ducks.add(new Duck(10, "OhTenten"));
        ducks.add(new Duck(4, "four"));
        System.out.println("ducks = " + ducks);
        Collections.sort(ducks);
        System.out.println("ducks = " + ducks);
        ducks.sort((a, b) -> b.age - a.age);
        System.out.println("ducks = " + ducks);
        // comparator is in java.util
        Comparator<Duck> comparator = Comparator.comparing(o -> o.name);
        ducks.sort(comparator);
        System.out.println("ducks = " + ducks);
//        Collections.sort(ducks, Comparator.comparing((Duck d1, Duck d2) -> d1.age - d2.age).thenComparing((Duck d1, Duck d2) -> d1.name.compareTo(d2.name)));
//        Collections.sort(ducks, Comparator.comparingInt((Duck b, Duck d) -> b.age-d.age);
        ducks.sort(Comparator.comparing(Duck::getAge).thenComparing(Duck::getName));
        System.out.println("ducks = " + ducks);
    }

    public static int compareAge(Duck d1, Duck d2) {
        return d1.age - d2.age;
    }

    public static int compareName(Duck d1, Duck d2){
        return d1.name.compareTo(d2.name);
    }
}

class Duck implements Comparable<Duck>{//comparable is in java.lang
    int age;
    String name;

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    Duck(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Duck d){
        return age - d.age;
    }
}
