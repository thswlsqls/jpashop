package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext // 스프링이 자동으로 주입, 등록함
    @Autowired // 스프링 데이터 JPA에서 지원함
    private final EntityManager em; // 스프링에서 JPA의 EntityManager를 스프링이 생성한 객체에 주입함

//    @RequiredArgsConstructor가 자동 생성함//
//    public MemberRepository(EntityManager em){
//        this.em = em;
//    }

//    @PersistenceUnit // 마찬가지로 스프링에서 EntityManagerFactory를 주입해줌
//    private EntityManagerFactory emf;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // 단건조회
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList(); //JPQL은 SQL로 번역되며 기능적으로는 동일하나, SQL과 달리 테이블이 아니라 엔티티 객체에 대해 질의함
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name) //JPQL에서 ":" 뒤의 문자는 파라미터 변수로 인식함
                .getResultList();
    }
}
