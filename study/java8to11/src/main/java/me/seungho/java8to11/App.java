package me.seungho.java8to11;

public interface App {
    void printName();

    // default를 사용하면 인터페이스 내에서 클래스를 깨지 않고도
    // 새기능을 추가할 수 있다.
    // 문서화를 쥰내 해야한. 적어도 무슨 일을 하는지는 적어야 한다.
    // 구현하는 쪽에서 재정의 가능
    // Object class에 있는 것들은 default로 재정의 불가능
    // 추상메서드로 선언하는것은 가능

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을
     * 대문자로 바꿔서 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    // 해당 인터페이스를 구현한 모든 인스턴스 또는 해당 타입과 관련된 헬퍼,유틸리티
    // 메서드를 제공하고 싶은 경우 static으로 정의할 수 있음
    static void printAnything(){
        System.out.println("FOO");
    }

    String getName();

}
