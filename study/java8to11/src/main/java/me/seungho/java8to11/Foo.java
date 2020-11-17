package me.seungho.java8to11;

import java.util.*;
import java.util.function.*;

public class Foo {

    public static void main(String[] args){
        //RunSomething runSomething = () -> System.out.println("Hello");

        // 입력값이 같은 경우 결과 값이 같아야 한다.
        // 함수의 밖에 있는 값을 변경하거나 가져와서 사용하지 않는다.
        // pure한 함수를 구현하려면 함수가 전달받은 인자만을 가지고
        // 처리해야한다.
//        RunSomething runSomething = (number) -> {
//            return number +10;
//        };
//        System.out.println(runSomething.doIt(1));
//        System.out.println(runSomething.doIt(1));
//        System.out.println(runSomething.doIt(1));

        // class를 만들어서 구현하는 경우
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));

        // 바로 구현 하는 경우
        Function<Integer, Integer> plus10 = (number) ->{
          return number+10;
        };
        Function<Integer, Integer> muliply2 = (i) -> i*2;


        System.out.println(plus10.apply(1));

        // 입력값을 가지고 먼저 뒤에 오는 함수를 적용해서 결과값을 다시 plus10의
        // 입력값으로 사용 -> compose
        Function<Integer, Integer> multiply2AndPlus10 =  plus10.compose(muliply2);
        System.out.println(multiply2AndPlus10.apply(2));

        // andThen : compose와는 반대로 앞에꺼 먼저하고 뒤에걸로 들어감
        System.out.println(plus10.andThen(muliply2).apply(2));

        // consumer :  아무값도 리턴하지 않음
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier : T 타입의 값을 제공하는 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        // T 타입을 받아서 boolean 리턴
        Predicate<String> startsWithSeungho = (s) -> s.startsWith("seungho");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        // UnaryOperator : 입력값 하나를 받아서 동일한 타입으로 리턴
        UnaryOperator<Integer> plus20 = (i) -> i + 10;


        // 메소드 레퍼런스
        // 기존에 이미 있는 메소드를 참조하는 것
        // static method 사용시
        UnaryOperator<String> hi = Greeting::hi;

        // instance method 사용시
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("seungho"));

        // constructor 참조
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        Function<String, Greeting> seunghoGreeting = Greeting::new;
        Greeting seungho = seunghoGreeting.apply("seungho");
        System.out.println(seungho.getName());

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"seungho", "mary", "maru"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        // 인터페이스를 구현한 모든 인스턴스에서 사용 가능
        // App에만 구현해놓고 구현체에는 없음
        App app = new DefaultApp("seungho");
        app.printName();
        app.printNameUpperCase();
        //static method
        App.printAnything();

        // java8 기본 메소드, 스태택 메소드
        List<String> name = new ArrayList<>();
        name.add("seungho");
        name.add("mary");
        name.add("maru");
        name.add("greyHound");

        name.forEach(System.out::println);
        // 쪼갤 수 있는 iterator
        // trySplit()의 경우 패러럴하게 처리할때 사용 가능
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("=========================");
        while (stringSpliterator.tryAdvance(System.out::println));

        name.removeIf(s -> s.startsWith("s"));
        name.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);


        //stream : Collection 같은 연속된 데이터를 처리하는 오퍼레이션들의 모음
        // 자체로는 데이터가 아님, functional in nature라고 스트림이 처리하는 데이터 소스는
        // 변경하지 않는다.
        // 중계 오퍼레이션 : 스트림을 리턴 / 종료 오퍼레이션 : 스트림을 리턴하지 않음
        // 중계형 오퍼레이터는 Lazy하다. 종료 오퍼레이션이 실행 되기 전까지는 정의만 된거
        // parallelStream은 병렬로 처리함 스레드간에 나눠서 처리할 경우 컨텍스트 스위칭 떔에
        // 더 느랴질 수 있음



    }
}

















