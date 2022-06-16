package com.course.qo;

import lombok.Data;

@Data
public class CommentInfoQo extends PageQo{
    private String commentId;
    private String studentId;
    private String commentContent;
    private String commentCtime;
    private String courseId;
    private String teacherId;
    private String teacherContent;
    private String stateId;
    private String courseName;
    private String beginTime;
    private String endTime;
    private String studentName;
}
