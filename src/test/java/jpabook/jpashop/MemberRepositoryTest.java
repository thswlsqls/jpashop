package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

//    @Autowired MemberRepository memberRepository;
//
//    // Preference > template > live template >custum
//
//    @Test
//    @Transactional //EntityManager를 통한 데이터 변경은 항상 트랜잭션 안에서 이루어져야 함
//    @Rollback(false)
//    public void testMember() throws Exception {
//
//        // Preferences > live template > user templete 커스텀 할 수 있음
//        //given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);
//        // 같은 트랜잭션 안에서 저장하고 조회하면 영속성 컨텐스트가 같음
//        // 같은 영속성 컨텍스트에서는 아이디(식별자) 값이 같으면 같은 엔티티로 인식함
//        // 저장했을 때 1차캐시에 저장된 영속성 컨텍스트의 엔티티에서 조회하므로 조회 쿼리는 생성되지조차 않음
//        // -> 이 케이스에서 p6spy로 select 쿼리를 확인할 수 없는 이유임
//        //System.out.println("findmember == member: " + (findMember == member));
//
//    }
}