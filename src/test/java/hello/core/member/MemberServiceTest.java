package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    @Test
    void join(){
        //given
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        //When
        memberService.join(member);
        //Then
        Member member1 = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
