package com.green.springjpa.config.relationenum;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnumMapper {
    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, toEnumValues(e));
    }

    //(e.getEnumConstants(): SchoolTypeCode[] schoolTypeCodeArray = [SchoolTypeCode.ELEMENTARY, SchoolTypeCode.MIDDLE, SchoolTypeCode.HIGH];
    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants()) //Array to Stream

                     //.map(item -> new EnumMapperValue(item)) 아래와 동일
                     .map(EnumMapperValue::new) //메소드 참조, 같은 크기의 stream을 만든다.
                     .toList(); // 최종 연산
    }
    //stream ( EnumMapperValue 객체, EnumMapperValue 객체, EnumMapperValue 객체 )
    //첫번째 EnumMapperValue 객체는 code="00101", value="초등학교"
    //두번째 EnumMapperValue 객체는 code="00102", value="중학교"
    //세번째 EnumMapperValue 객체는 code="00103", value="고등학교"
    //최종 연산은 toList니까 Stream > ArrayList로 변환

    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }
}
