package com.course.vo;

import com.course.pojo.CourseInfo;
import lombok.Data;

@Data
public class CourseInfoVo extends CourseInfo {
    private String teacherName;
    private String stateName;
    private String teacherNick;
}
