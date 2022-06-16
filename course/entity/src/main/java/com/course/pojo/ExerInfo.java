package com.course.pojo;


import lombok.Data;

@Data
public class ExerInfo {
    private int exerId;
    private String exerContent;
    private int stateId;
    private String exerCtime;
    private String exerMtime;
    private int typeId;
    private int trainId;
    private int examId;
    private String exerAnswer;
    private String exerAnaly;
    private int exerValue;

    private String []lastquestions;

}
