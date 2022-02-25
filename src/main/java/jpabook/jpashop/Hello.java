package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

// lombok 설정하기 1. Preferences > plugin > lombok update 확인
// lombok 설정하기 2. Preferences > annotation Processors > enable annotation Processing
@Getter
@Setter
public class Hello {
    private String data;
}
