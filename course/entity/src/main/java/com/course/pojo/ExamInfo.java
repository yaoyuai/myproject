package com.course.pojo;


import lombok.Data;

@Data
public class ExamInfo {
    private int examId;
    private String examName;
    private int teacherId;
    private int stateId;
    private String examCtime;
    private String examMtime;
    private int courseId;
}
