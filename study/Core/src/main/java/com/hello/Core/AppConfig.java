package com.hello.Core;

import com.hello.Core.discount.DiscountPolicy;
import com.hello.Core.discount.FixDiscountPolicy;
import com.hello.Core.discount.RateDiscountPolicy;
import com.hello.Core.member.MemberRepository;
import com.hello.Core.member.MemberService;
import com.hello.Core.member.MemberServiceImpl;
import com.hello.Core.member.MemoryMemberRepository;
import com.hello.Core.order.OrderService;
import com.hello.Core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        // 이런식으로 정책을 바꾸도 클라이언트 쪽에서 코드를 안바꿔도 됨
        return new RateDiscountPolicy();
    }

}




