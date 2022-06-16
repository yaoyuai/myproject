package com.course.mapper;
import com.course.pojo.StudentInfo;
import com.course.qo.StudentInfoQo;
import com.course.vo.StudentInfoVo;

import java.util.List;

public interface StudentInfoMapper {
    StudentInfo judgeLogin(StudentInfoQo studentInfoQo);

    int addStudent(StudentInfoQo studentInfoQo);

    StudentInfo judgeRegistHasName(String studentName);

    List<StudentInfoVo> showAllStudent(StudentInfoQo studentInfoQo);

    int showAllStudentCount(StudentInfoQo studentInfoQo);

    int adminAddStudent(StudentInfoQo studentInfoQo);

    int adminUpdateStudent(StudentInfoQo studentInfoQo);

    int adminLogOutStudent(StudentInfoQo studentInfoQo);

    StudentInfo selectParentHasStudent(String parentId);

    int resetPwd(StudentInfoQo studentInfoQo);

    List<StudentInfoVo> showBan(StudentInfoQo studentInfoQo);

    int showBanCount(StudentInfoQo studentInfoQo);

    int ban(StudentInfoQo studentInfoQo);

    int jieBan(StudentInfoQo studentInfoQo);

    List<StudentInfoVo> showStudentByParentId(StudentInfoQo studentInfoQo);
}
