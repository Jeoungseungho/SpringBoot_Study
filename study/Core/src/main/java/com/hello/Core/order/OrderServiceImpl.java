package com.hello.Core.order;

import com.hello.Core.discount.DiscountPolicy;
import com.hello.Core.discount.FixDiscountPolicy;
import com.hello.Core.discount.RateDiscountPolicy;
import com.hello.Core.member.Member;
import com.hello.Core.member.MemberRepository;
import com.hello.Core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //사실 OCP원칙에 위배 , DIP에도 위배
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 이렇게 하면 구체화에 의존하지 않고 인터페이스에 의존하게 된다.
    //private DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
























