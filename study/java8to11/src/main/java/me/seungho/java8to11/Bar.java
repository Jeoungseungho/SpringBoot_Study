package me.seungho.java8to11;

public interface Bar {
    // 만약 App이 제공하는 기본 구현체를 제공하고 싶지 않다면
    // 추상 메서드로 선언하면 됨

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
