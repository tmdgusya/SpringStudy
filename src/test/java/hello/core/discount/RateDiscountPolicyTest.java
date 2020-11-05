package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //givne
        Member member = new Member(1L, "MemberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인은 미적용 되어야 한다.")
    void vip_x(){
        Member member = new Member(1L, "MemberB", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }



    void discount() {

    }
}