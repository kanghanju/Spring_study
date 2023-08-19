package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {//class 전체 테스트 결과 findByName()에 에러발생
    //모든 Test는 순서랑 상관없이 method별로 다 따로 동작하게 설계해야 한다. 순서에 의존적으로 설계하면 안된다.
    //따라서 Test 하나가 끝나면 데이터를 clear해줘야 한다.

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //method가 실행이 끝날때마다 어떤 동작을 하는 것
    public void afterEach(){
        repository.clearStore();
    }

    @Test //save()가 동작하는지 확인해본다.
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift F6: Rename
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }

}
