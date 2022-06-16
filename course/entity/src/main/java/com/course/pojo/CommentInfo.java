package com.course.pojo;


import lombok.Data;

@Data
public class CommentInfo {
    private int commentId;
    private int studentId;
    private String commentContent;
    private String commentCtime;
    private int courseId;
    private int teacherId;
    private String teacherContent;
    private int stateId;
}
