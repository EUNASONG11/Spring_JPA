package com.green.springjpa.config.relationenum;

import lombok.Getter;
import lombok.ToString;

//응답용
@Getter
@ToString
public class EnumMapperValue {
    private String code;
    private String value;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        this.code = enumMapperType.getCode();
        this.value = enumMapperType.getValue();
    }
}
