package com.green.springjpa.entity;

import com.green.springjpa.config.relationenum.AbstractEnumCodeConvertor;
import com.green.springjpa.config.relationenum.EnumMapperType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SchoolTypeCode implements EnumMapperType {
      ELEMENTARY("00101", "초등학교")
    , MIDDLE("00102", "중학교")
    , HIGH("00103", "고등학교");

    private final String code;
    private final String value;

    //보일러 플레이트 코드
    @Converter(autoApply = true) //@Converter(autoApply = true) : SchoolTypeCode Enum 을 사용하는 Entity는 자동으로 Converter가 작동한다.
    public static class CodeConverter extends AbstractEnumCodeConvertor<SchoolTypeCode> {
        public CodeConverter() {
            super(SchoolTypeCode.class, false);
        }
    }
}
