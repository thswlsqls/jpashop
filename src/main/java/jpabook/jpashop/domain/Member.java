package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //@Embedded, @Embeddable 둘 중 하나만 있으면 됨
    private Address adress;

    @OneToMany(mappedBy = "member") // 읽기전용 거울임, order 테이블의 member필드에 의해 매핑되었음, 다시말해 디비에서 order 테이블의 member_id 외래키 컬럼으로 검색함
    private List<Order> orders = new ArrayList<>();

}
