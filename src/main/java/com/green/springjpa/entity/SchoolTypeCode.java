package com.green.springjpa.entity;

import com.green.springjpa.config.relationenum.AbstractEnumCodeConvertor;
import com.green.springjpa.config.relationenum.EnumMapperType;
import jakarta.persistence.AttributeConverter;
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

    public static class CodeConverter extends AbstractEnumCodeConvertor<SchoolTypeCode> {
        private static final String ENUM_NAME = "학교 타입";

        public CodeConverter() {
            super(SchoolTypeCode.class, false, ENUM_NAME);
        }
    }
}
