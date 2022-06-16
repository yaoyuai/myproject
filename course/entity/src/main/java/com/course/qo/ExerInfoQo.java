package com.course.qo;

import lombok.Data;

@Data
public class ExerInfoQo extends PageQo {
    private String exerId;
    private String exerContent;
    private String stateId;
    private String exerCtime;
    private String exerMtime;
    private String typeId;
    private String trainId;
    private String examId;
    private String exerAnswer;
    private String exerAnaly;
    private String exerValue;

    private String lastquestions;
}
