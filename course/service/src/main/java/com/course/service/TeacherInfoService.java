package com.course.service;

import com.course.pojo.TeacherInfo;
import com.course.qo.TeacherInfoQo;
import com.course.vo.TeacherInfoVo;

import java.util.List;

public interface TeacherInfoService {

    TeacherInfo judgeLogin(TeacherInfoQo teacherInfoQo);

    int userAddTeacher(TeacherInfoQo teacherInfoQo);

    TeacherInfo judgeHasName(String teacherName);

    List<TeacherInfoVo> showAllTeacher(TeacherInfoQo teacherInfoQo);

    int showAllTeacherCount(TeacherInfoQo teacherInfoQo);


    int adminAddTeacher(TeacherInfoQo teacherInfoQo);

    int adminUpdateTeacher(TeacherInfoQo teacherInfoQo);

    int adminLogOutTeacher(TeacherInfoQo teacherInfoQo);

    int resetPwd(TeacherInfoQo teacherInfoQo);

    int updatePwd(TeacherInfoQo teacherInfoQo);

}
