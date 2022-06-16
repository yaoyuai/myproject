package com.course.pojo;


import lombok.Data;

@Data
public class EvaluationInfo {
    private int evaluationId;
    private int studentId;
    private int evaluationScore;
    private String evaluationCtime;
    private int courseId;
    private String evaluationContent;
}
