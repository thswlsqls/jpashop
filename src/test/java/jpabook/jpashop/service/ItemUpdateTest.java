package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void 상품수정() throws Exception {
        //given
        Book book = em.find(Book.class, 1L);

        //when
        //TX
        book.setName("dlasdasf");

        // 변경감지 -> dirty checking 플러쉬할때 실행됨
        // TX commit

        //then

    }

}
