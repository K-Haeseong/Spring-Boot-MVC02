package hello.login.domain.login;


import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null이면 로그인 실패
     */

    public Member login(String loginId, String password) {

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);

        // 여기서 아이디를 오류를 찾았으니 비밀번호만 비교하면 된다.
        /*Optional<Member> findMemeberOptional = memberRepository.findByLoginId(loginId);
        Member member = findMemeberOptional.get(); // 없으면 오류난다
        if (member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }*/
    }
}
