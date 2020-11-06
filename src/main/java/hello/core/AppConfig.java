package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //의존성을 최대한 낮추는 코드 기법임 !, 구현부는 구현만 할 수 있게! 비즈니스 로직의 분리!!!
    //생성자를 통한 의존성 주입 ( => 생성자 주입)
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }


    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}

