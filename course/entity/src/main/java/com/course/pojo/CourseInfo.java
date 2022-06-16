package com.course.pojo;

import lombok.Data;

@Data
public class CourseInfo {
    private int courseId;
    private String courseName;
    private int teacherId;
    private String courseDes;
    private int stateId;
    private String courseCtime;
    private String courseMtime;
    private int courseSelect;
    private String courseImg;
}
