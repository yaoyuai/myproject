package com.course.qo;

import lombok.Data;

@Data
public class TeacherInfoQo extends PageQo{

    private String teacherId;
    private String teacherName;
    private String teacherNick;
    private String teacherPwd;
    private String stateId;
    private String teacherCtime;
    private String teacherMtime;
    private String roleId;

    private String code;
}
