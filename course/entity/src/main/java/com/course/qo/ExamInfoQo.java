package com.course.qo;

import lombok.Data;

@Data
public class ExamInfoQo extends PageQo{
    private String examId;
    private String examName;
    private String teacherId;
    private String stateId;
    private String examCtime;
    private String examMtime;
    private String courseId;
    private String courseName;
    private String studentId;
}
