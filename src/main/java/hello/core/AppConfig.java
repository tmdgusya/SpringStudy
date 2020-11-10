package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Configuration Annotaion 이 있는 Spring Container 자체가 SingleTon Pattern
@Configuration
public class AppConfig {

    //의존성을 최대한 낮추는 코드 기법임 !, 구현부는 구현만 할 수 있게! 비즈니스 로직의 분리!!!
    //생성자를 통한 의존성 주입 ( => 생성자 주입) => Dependency Injection
    //생성 주입 용 Config Class자
    //관심사의 분리!

    @Bean(name = "memberService") // name 으로 직접 지정도 가능하다.
    public MemberService memberService(){ // key
        return new MemberServiceImpl(memberRepository()); // value
    }

    @Bean(name = "memberRepository")
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean // name default 는 함수명!
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

