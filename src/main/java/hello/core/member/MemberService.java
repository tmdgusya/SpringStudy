package hello.core.member;

import org.springframework.stereotype.Component;

@Component
public interface MemberService {

    public void join(Member member);

    public Member findMember(Long memberId);

}
