package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {/*비즈니스에 가까운 용어를 써야한다,비즈니스에 의존적으로 설계 */

    // 회원 서비스를 만드려면 회원 리포지토리가 있어야 한다
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /*
    * 기능: 회원가입
    * */
    public Long join(Member member){
//        같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());

//        만약 멤버에 null이 아닌 값이 있다면
//        과거에는 ifNull이라면 이런식으로 코딩을 했지만 지금은 null일 가능성이 있으면 Optional로 한 번 감싼다
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member); //중복 회원 검증 shift+ctrl+alt+t: Extract Method
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /*
    * 기능: 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
