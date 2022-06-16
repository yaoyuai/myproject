package com.course.pojo;


import lombok.Data;

@Data
public class TrainInfo {
    private int trainId;
    private String trainName;
    private int teacherId;
    private int stateId;
    private String trainCtime;
    private String trainMtime;
    private String courseId;
}
