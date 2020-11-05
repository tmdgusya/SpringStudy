package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    @Test
    void join(){
        //given
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        //When
        memberService.join(member);
        //Then
        Member member1 = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(member1);
    }
}
