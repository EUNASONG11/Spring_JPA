package com.green.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //private 기본 생성자, 외부에서 객체 생성을 하지 못하도록, 즉, static 메소드 그리고 부모로서의 역할만 할 때 사용
public class EnumConvertUtils {
    //enumClass: SchoolTypeCode.class, code: "00101" >> SchoolTypeCode.ELEMENTARY 타입이 리턴
    //enumClass: SchoolTypeCode.class, code: "00102" >> SchoolTypeCode.MIDDLE 타입이 리턴
    public static <E extends Enum<E> & EnumMapperType> E ofCode(Class<E> enumClass, String code) {
        //extends Enum<E> & EnumMapperType 을 함으로써 Enum이면서 EnumMapperType을 상속받은 것만 추가
        if (StringUtils.isBlank(code)) { //StringUtils.isBlank(code)는 null 이거나 빈 문자열이면 true를 반환
            return null;
        }
        return EnumSet.allOf(enumClass) // Enum이 가지고 있는 모든 item들을 가진 collection return
                      .stream() // allof를 stream 생성
                      .filter(item -> item.getCode().equals(code)) //filter를 거치면 원래보다 작거나 같다. 커질 순 없다. stream item 중에 원하느 item만 다시 stream 생성
                      .findFirst() // 위의 stream item 중 첫 번째 item을 return(Optional)
                      .orElse(null); // 혹시나 findFirst()가 아무 값도 가지고 있지 않다면 null return
    }

    // enumItem으로 SchoolTypeCode.ELEMENTARY가 들어오면 "00101"가 리턴
    // enumItem으로 SchoolTypeCode.MIDDLE이 들어오면 "00102"가 리턴
    public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem) {
        if (enumItem == null) {
            return null;
        }
        return enumItem.getCode();
    }
}
