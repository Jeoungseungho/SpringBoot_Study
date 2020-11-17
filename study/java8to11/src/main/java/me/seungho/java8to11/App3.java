package me.seungho.java8to11;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App3 {
    public static void main(String[] args){
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot", true));
        springClasses.add(new OnlineClass(5,"rest api development", false));

        Optional<OnlineClass> onlineClasses = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        /*
        // Optional에 값 있는지 없는지 확인
        boolean present = onlineClasses.isPresent();
        System.out.println(present);
         */

        /*
        // Optional의 값 가져오기 : 비어있는 경우 runtimeException 걸림
        OnlineClass onlineClass1 = onlineClasses.get();
        System.out.println(onlineClass1.getTitle());
         */
        onlineClasses.ifPresent(oc -> System.out.println(oc.getTitle()));

        // orElse : Optional에 값이 있으면 가져오고 아니면 ~~ 리턴 -> 값이 있든 없든
        // 인스턴스는 무조건 실행 됨
         //OnlineClass onlineClass =  onlineClasses.orElse(createNewClass());
        //OnlineClass onlineClass =  onlineClasses.orElseGet(App3::createNewClass);

        // Optional에 값이 없는 경우 예외 던짐
        //OnlineClass onlineClass =  onlineClasses.orElseThrow(IllegalStateException::new);
        //System.out.println(onlineClass.getTitle());



    }

    private static OnlineClass createNewClass(){
        System.out.println("creating new online class");
        return new OnlineClass(10,"New class", false);
    }


}
