package com.course.vo;

import com.course.pojo.ExamInfo;
import lombok.Data;

@Data
public class ExamInfoVo extends ExamInfo {
    private String courseName;
    private String stateName;
    private String teacherName;
    private String examState;
}
