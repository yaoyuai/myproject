package com.course.qo;

import lombok.Data;

@Data
public class TrainInfoQo extends PageQo{

    private String trainId;
    private String trainName;
    private String teacherId;
    private String stateId;
    private String trainCtime;
    private String trainMtime;
    private String courseId;

    private String courseName;
}
