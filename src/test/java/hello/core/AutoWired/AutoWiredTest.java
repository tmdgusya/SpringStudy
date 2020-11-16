package hello.core.AutoWired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean {

        @Autowired(required = false) // 대상이 없으면 호출 자체가 안됨
        public void setNoBean1(Member noBean1){
            System.out.println("Member : " + noBean1);
        }

        @Autowired // 호출은됨, 대신 주입할 객체가 없으면 null 을 리
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("Member2 : " + noBean2);
        }

        @Autowired // 호출은 됨, 대신 주입할객체가 없으면 Optional.empty를 리턴함
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("Member3 : " + noBean3);
        }
    }
}
