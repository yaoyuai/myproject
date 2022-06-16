package com.course.qo;

import lombok.Data;

@Data
public class EvaluationInfoQo extends PageQo{
    private String evaluationId;
    private String studentId;
    private String evaluationScore;
    private String evaluationCtime;
    private String courseId;
    private String evaluationContent;
    private String courseName;
    private String studentName;
}
