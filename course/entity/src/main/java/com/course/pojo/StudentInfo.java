package com.course.pojo;


import lombok.Data;

@Data
public class StudentInfo {
    private int studentId;
    private String studentName;
    private String studentNick;
    private String studentPwd;
    private int parentId;
    private int stateId;
    private String studentSex;
    private String studentCtime;
    private String studentMtime;
}
