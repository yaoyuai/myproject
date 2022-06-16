package com.course.vo;


import com.course.pojo.EvaluationInfo;
import lombok.Data;

@Data
public class EvaluationInfoVo extends EvaluationInfo {
    private String courseName;
    private String studentName;
}
