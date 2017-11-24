package InputOutput;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
    public InputOutput() {

//        method1();
//        method2();
//        method3();
//        method4();
        method5();
    }

    void method5(){
        try{
            throw new NullPointerException("npe");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

//        System.out.println("/////////////////////////////////");
//
//        try{
//            throw new ArrayIndexOutOfBoundsException("arrays!!!");
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }

//        System.out.println("/////////////////////////////////");
//
//        try{
//            throw new ArrayIndexOutOfBoundsException("arrays!!!");
//        }catch (Exception e){
//            System.out.println(e);
//        }

    }

    void method4(){
        List <String> allLines = new ArrayList<>();
        List<Path> allPaths = new ArrayList<>();
        try {
            Files.walk(Paths.get("."))
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(allPaths::add);
        }catch (IOException e){}
        System.out.println("allPaths.size() = " + allPaths.size());
        allPaths.forEach(p -> {
            try {
                Files.lines(p, Charset.defaultCharset()).forEach(allLines::add);
            }catch (IOException e){e.printStackTrace();}
        });
        System.out.println("allLines.size() = " + allLines.size());
        allLines.forEach(System.out::println);
    }

    void method3(){
        int a = 0;
        try{
            System.out.println(Files.walk(Paths.get("."), FileVisitOption.FOLLOW_LINKS)
//                    .filter(p -> p.toString().endsWith(".java"))
                    .peek(p -> System.out.println("p = " + p))
                    .count());
        }catch (IOException e){

        }
    }

    private void method1() {
        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println ("You entered the following: "+userInput);
        }else {
            System.out.println("console is null");
        }
    }

    void method2(){
        Scanner userInput = new Scanner(System.in);
        String name = "";
        int age = 0;
        System.out.print("Enter age: ");
        if (userInput.hasNextInt()) {
            age = userInput.nextInt();
        } else {
            throw new IllegalArgumentException("should have entered an int value!");
        }
        System.out.print("ENter name: ");
        userInput.nextLine();
        if (userInput.hasNextLine()) {
            name = userInput.nextLine();
        }
        System.out.println(name + " " + age);
    }
}
