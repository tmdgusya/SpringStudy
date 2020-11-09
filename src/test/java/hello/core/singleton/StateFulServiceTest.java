package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    //SingleTon Pattern 에 Write 한 function 을 쓰면 일어나는 경우이다.
    //Spring Bean 은 항상 Stateless 하계 설계해야함.
    @Test
    void  statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService bean = ac.getBean(StateFulService.class);
        StateFulService bean1 = ac.getBean(StateFulService.class);
        bean.order("userA", 10000);
        bean1.order("userB", 20000);


        org.assertj.core.api.Assertions.assertThat(bean.order("userA", 10000)).isEqualTo(10000);
        org.assertj.core.api.Assertions.assertThat(bean1.order("userB", 20000)).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}