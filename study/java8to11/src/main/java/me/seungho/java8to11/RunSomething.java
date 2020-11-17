package me.seungho.java8to11;

@FunctionalInterface
public interface RunSomething {
    // 추상 메서드가 하나만 있으면 그것이 함수형 인터페이스이다.
   //void doIt();
    int doIt(int number);

   // public keyword 생략가능
   static void printName(){
       System.out.println("seungho");
   }

   default void printAge(){
       System.out.println("26 Years Old");
   }

}
