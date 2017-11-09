package Chapter4;

import sun.java2d.pipe.SpanShapeRenderer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Streams {
    public Streams(){
        SimpleStreams simpleStreams = new SimpleStreams();
//        simpleStreams.method();
//        simpleStreams.reductions();
//        simpleStreams.newReduction();
//        simpleStreams.collecting();
//        simpleStreams.dateStreams();
//        simpleStreams.advancedStuff();
        CollectingComplicatedStuff collectingComplicatedStuff = new CollectingComplicatedStuff();
        collectingComplicatedStuff.method1();
    }
}

class CollectingComplicatedStuff {
    void method1(){
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears", "oh my");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears
        System.out.println(Function.identity());
        Collector collector = Collectors.groupingBy(String::length);

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");

        Map<Integer, Set<String>> map = ohMy1.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));

//        Map<Integer, Set<String>> map3 = ohMy1.collect(
//                Collectors.groupingBy(String::length));

        Map<Integer, List<String>> map1 = ohMy1.collect(
                Collectors.groupingBy(String::length, Collectors.toList()));

        Map<Integer, List<String>> map2 = ohMy1.collect(
                Collectors.groupingBy(String::length));
    }
}

class SimpleStreams{

    void advancedStuff(){
        DoubleToIntFunction doubleToIntFunction = x -> 1;
        System.out.println("doubleToIntFunction = " + doubleToIntFunction);
    }

    void collecting(){
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        System.out.println("word = " + word);

        Stream<String> stream11 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream11.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);

        Stream<String> stream22 = Stream.of("w", "o", "l", "f");
        Set<String> set22 = stream22.collect(Collectors.toSet());
        System.out.println(set22);

        List<Integer> ten = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        System.out.println("count "+ten.stream().peek(System.out::println).limit(34).count());
        System.out.println("min " +ten.stream().min(Comparator.naturalOrder()));
        System.out.println("min " +ten.stream().min(Comparator.reverseOrder()));

    }

    public void dateStreams() {
        LocalDate start = LocalDate.of(2017, Month.AUGUST, 14);
        Period period = Period.ofMonths(6);
        LocalDate limit = start.plus(period);
        System.out.println("limit = " + limit.format(DateTimeFormatter.ofPattern("uuuu-MMMM-dd")));
        System.out.println(" start + limit = "+start.plusMonths(6));

        LocalDate now = LocalDate.now();
        Stream<LocalDate> dateStream = Stream.iterate(now, date -> date.plusDays(1));
        dateStream.limit(30).filter(date -> !(date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY))
                .forEach(date -> System.out.println(date.getYear()+" "+date.getMonth()+" "+date.getDayOfWeek()+" "+date.getDayOfMonth()));
        Stream<LocalDate> dateStreamYears = Stream.iterate(now, date -> date.plusYears(1));
        dateStreamYears.limit(20).forEach(date -> System.out.println(date.getYear()+" is leap year = "+date.isLeapYear()));
    }

    void newReduction(){
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s, c) -> s + c);
        System.out.println(word); // wolf

        Stream<Integer> stream11 = Stream.of(3, 5, 6);
        System.out.println(stream11.reduce(1, (a, b) -> a*b));
    }

    void reductions(){
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
//        Optional<String> minn = s.min(Comparator.comparing(String::length));
        min.ifPresent(System.out::println); // ape
        System.out.println("min = " + min);
    }

    void method(){
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1,2,3);
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

//        randoms.forEach(System.out::println);
        System.out.println("oddnumbers.allMatch 5 "+oddNumbers.allMatch(n -> n == 5));
        oddNumbers = Stream.iterate(1, n -> n + 2);
        System.out.println("oddnumbers.noneMatch 5 "+oddNumbers.noneMatch(n -> n == 5));
        oddNumbers = Stream.iterate(1, n -> n + 2);
        System.out.println("oddnumbers.anyMatch 5 "+oddNumbers.anyMatch(n -> n == 5));
    }
}