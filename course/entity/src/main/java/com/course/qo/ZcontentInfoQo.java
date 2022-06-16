package com.course.qo;

import lombok.Data;

@Data
public class ZcontentInfoQo extends PageQo{
    private String zcontentId;
    private String examId;
    private String studentId;
    private String zcontentAnswer;
    private String stateId;
    private String zcontentCtime;
    private String zcontentMtime;
    private String exerId;
}
