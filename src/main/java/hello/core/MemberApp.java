package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig(); => 기존 의존성 주입방법
//       MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // ApplicationContext 는 스프링 컨테이
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// name 은 method 이름으로 등록되어 있
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("Member : " + member.getName());
        System.out.println("Find Member :" + member1.getName());
    }
}
