package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //SINGLE_TABLE 전략일 때 클래스 구분자
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
