package com.green.springjpa.school.model;

import com.green.springjpa.entity.SchoolTypeCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SchoolPostReq {
    private String schoolName;
    private SchoolTypeCode typeCode;
}
