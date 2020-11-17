package com.hello.Core;

import com.hello.Core.member.Grade;
import com.hello.Core.member.Member;
import com.hello.Core.member.MemberService;
import com.hello.Core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();


        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
