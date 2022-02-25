package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext // 스프링 부트가 EntityManager를 주입해줌
    private EntityManager em; // 스프링 컨테이너에서 JPA를 사용하기 위한 객체

    public Long save(Member member){
        em.persist(member);
        return member.getId(); // 데이터를 저장한 후에는사이드 이펙트를 유발하는 커맨드와 쿼리를 분리함
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
