package com.green.springjpa.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//Annotation에서 yaml에 있는 데이터 사용 방법 ${속성명}
@OpenAPIDefinition(
        info = @Info(
                title= "${constants.swagger.info.title}"
                , description = "${constants.swagger.info.description}"
                , version = "${constants.swagger.info.version}"
        )
)
public class SwaggerConfiguration {
}
