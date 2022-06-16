package com.course.qo;


import lombok.Data;

@Data
public class StudentInfoQo extends PageQo{

    private String studentId;
    private String studentName;
    private String studentNick;
    private String studentPwd;
    private String parentId;
    private String stateId;
    private String studentSex;
    private String studentCtime;
    private String studentMtime;


    private String code;
}
