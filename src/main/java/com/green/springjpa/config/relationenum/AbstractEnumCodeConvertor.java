package com.green.springjpa.config.relationenum;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractEnumCodeConvertor<E extends Enum<E> & EnumMapperType> implements AttributeConverter<E,String> {
    private final Class<E> targetEnumClass;
    private final boolean nullable; // null 가능

    //DB에 값을 넣을 때 사용(INSERT, UPDATE)
    @Override
    public String convertToDatabaseColumn(E enumItem) {
        if (!nullable && enumItem == null) { // null 허용을 하지 않았는데 enumItem 값이 null 이었다면
            throw new IllegalArgumentException(String.format("%s(는)은 NULL로 지정할 수 없습니다.", targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.toCode(enumItem);
    }

    //DB에 값을 가져올 때 사용(SELECT)
    @Override
    public E convertToEntityAttribute(String dbData) {
        if (!nullable && StringUtils.isBlank(dbData) || dbData == null) {
            throw new IllegalArgumentException(String.format("%s(이)가 DB에 NULL 혹은 Empty로 지정되어 있습니다.", targetEnumClass.getSimpleName()));
        }
        return EnumConvertUtils.ofCode(targetEnumClass, dbData);
    }
}
