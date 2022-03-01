package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 메서드 종료시마다 기본적으로 롤백함, 트랜잭션 카밋을 다루는 것이 중요함
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
//    @Rollback(false) // 자동 커밋 등에 의해 트랜잭션이 커밋되도록 허용함
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member); // em.persist(member)가 호출될 때 즉시 데이터베이스에 insert문이 나가는 것이 아님, commit할 때 플러쉬되며 비로소 insert문을 생성함

        //then
        em.flush(); // 영속성 컨텍스트의 변경 및 등록내역을 데이터베이스에 반영함
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
//        try{
            memberService.join(member1);
            memberService.join(member2); //예외가 발생해야 함
//        } catch(IllegalStateException e){
//            return;
//        }

        //then
        fail("예외가 발생해야 합니다.");
    }

}