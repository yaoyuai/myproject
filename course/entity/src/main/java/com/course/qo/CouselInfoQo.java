package com.course.qo;


import lombok.Data;

@Data
public class CouselInfoQo extends PageQo{

    private String couselId;
    private String studentId;
    private String courseId;
    private String stateId;
    private String couselCtime;
    private String couselMtime;
    private String examId;

}
