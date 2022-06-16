package com.course.vo;

import com.course.pojo.StudentInfo;
import lombok.Data;

@Data
public class StudentInfoVo extends StudentInfo {
    private String stateName;
    private String parentName;
}
