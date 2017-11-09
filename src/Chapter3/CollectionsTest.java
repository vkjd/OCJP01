package Chapter3;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionsTest {
    public CollectionsTest(){
        System.out.println(">>> CollectionsTest");

        new Lists();
        new Sets();
        new Queues();
        new Maps();
    }
}

class Lists{//all lists are ordered
    Lists() {
        System.out.println("\t>>> Lists");
        List<String> list = new ArrayList<>();
        list.add("a string");
        List<String> linked = new LinkedList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }
}

class Sets{// HashSet loses order, TreeSet is sorted
    Sets() {
        System.out.println("\t>>> Sets");
        NavigableSet<Integer> ns = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10));
        System.out.println("lower 5 "+ns.lower(5));
        System.out.println("floor 5 "+ns.floor(5));
        System.out.println("ceiling 5 "+ns.ceiling(5));
        System.out.println("higher 5 "+ns.higher(5));
    }
}

class Queues{
    Queues() {
        System.out.println("\t>>> Queues");
        Queue<Integer> kyu = new LinkedList<>();
        Queue<Integer> deka = new ArrayDeque<>();
        ArrayDeque<Integer> deka2 = new ArrayDeque<>();

        IntStream.range(0, 10).forEach(deka::add);
        System.out.println("deka = " + deka);
        System.out.println("deka element "+deka.element());
        System.out.println("deka = " + deka);
        IntStream.range(0, 10).forEach(deka::offer);
        System.out.println("deka = " + deka);
        System.out.println("deka remove "+deka.remove());
        System.out.println("deka = " + deka);
//        deka.push(22);
        deka2.push(22);
        deka2.push(33);
        System.out.println("deka2 = " + deka2);
        System.out.println("deka poll "+deka.poll());
        System.out.println("deka = " + deka);
        System.out.println("deka2 pop "+deka2.pop());
        System.out.println("deka2 = " + deka2);

    }
}

class Maps{//no ordering, except in LinkedHashMap, TreeMap sorts keys
    Maps() {
        System.out.println("\t>>> Maps");
        Map<Integer, Integer> mappen = new HashMap<>();
        System.out.println("put 1 11 "+mappen.put(1, 11));
        System.out.println("put 2 22 "+mappen.put(2, 22));
        System.out.println("put 2 33 "+mappen.put(2, 33));
        System.out.println("mappen = " + mappen);
        System.out.println("mappen contains 33 "+mappen.containsValue(33));
        System.out.println("mappen keyset "+mappen.keySet());
        System.out.println("mappen values "+mappen.values());
        mappen.put(null, 55);
        mappen.put(44, null);
        System.out.println("mappen = " + mappen);

    }
}
