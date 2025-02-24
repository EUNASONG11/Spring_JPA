package com.green.springjpa.config.relationenum;

import com.green.springjpa.entity.SchoolTypeCode;
import com.green.springjpa.entity.StudentGradeTypeCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @Configuration: 빈 등록, @Bean 애노테이션을 가진 메소드가 있을 수 있다.
    @Bean: 빈 등록, 스프링 컨테이너가 이 메소드를 호출 > 리턴된 주소값을 빈 등록

    @Configuration 아래에 있는 @Bean은 싱글톤이다.(객체 생성 딱 한번만 하는 것)
 */
@Configuration
public class EnumCodeConfiguration {
    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put(SchoolTypeCode.class.getSimpleName(), SchoolTypeCode.class);
        enumMapper.put(StudentGradeTypeCode.class.getSimpleName(), StudentGradeTypeCode.class);
        return enumMapper;
    }
}
