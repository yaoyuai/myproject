package com.course.qo;

import lombok.Data;

@Data
public class CourseInfoQo extends PageQo{
    private String courseId;
    private String courseName;
    private String teacherId;
    private String courseDes;
    private String stateId;
    private String courseCtime;
    private String courseMtime;
    private String courseSelect;
    private String courseImg;

    private String teacherName;
    private String filePath;
    private String materialName;
}
