package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)//join과 같은 쓰기에는 readOnly=true 사용하지 말기, 읽기에서만 사용
@RequiredArgsConstructor //final 필드만 가지고 생성자를 만들어줌
public class MemberService {

    //@Autowired
    private final MemberRepository memberRepository;

   /* @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }중간에 변경가능함- 단점 */

    //@Autowired 생성자가 하나만 있는 경우 자동으로 주입
   /* public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } @AllArgsConstructor를 달아주면 자동으로 만들어줌 */

    /**
     * 회원 가입
     */

    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
