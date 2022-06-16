package com.course.service.impl;

import com.course.mapper.TeacherInfoMapper;
import com.course.pojo.TeacherInfo;
import com.course.qo.TeacherInfoQo;
import com.course.service.TeacherInfoService;
import com.course.vo.TeacherInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    @Override
    public TeacherInfo judgeLogin(TeacherInfoQo teacherInfoQo) {
        if(teacherInfoQo.getTeacherName()==null || teacherInfoQo.getTeacherName().trim().isEmpty()){
            return null;
        }
        if(teacherInfoQo.getTeacherPwd()==null || teacherInfoQo.getTeacherPwd().trim().isEmpty()){
            return null;
        }
        return teacherInfoMapper.judgeLogin(teacherInfoQo);
    }

    @Override
    public int userAddTeacher(TeacherInfoQo teacherInfoQo) {

        if(teacherInfoQo.getTeacherName()==null || teacherInfoQo.getTeacherName().trim().isEmpty()){
            return 0;
        }
        if(teacherInfoQo.getTeacherPwd()==null || teacherInfoQo.getTeacherPwd().trim().isEmpty()){
            return 0;
        }
        if(teacherInfoQo.getTeacherNick()==null || teacherInfoQo.getTeacherNick().trim().isEmpty()){
            return 0;
        }
        return teacherInfoMapper.userAddTeacher(teacherInfoQo);
    }

    @Override
    public TeacherInfo judgeHasName(String teacherName) {
        return teacherInfoMapper.judgeHasName(teacherName);
    }

    @Override
    public List<TeacherInfoVo> showAllTeacher(TeacherInfoQo teacherInfoQo) {

        if(teacherInfoQo.getTeacherName()==null || teacherInfoQo.getTeacherName().trim().isEmpty()){
            teacherInfoQo.setTeacherName(null);
        }
        if(teacherInfoQo.getTeacherNick()==null || teacherInfoQo.getTeacherNick().trim().isEmpty()){
            teacherInfoQo.setTeacherNick(null);
        }
        if(teacherInfoQo.getStateId()==null || teacherInfoQo.getStateId().equals("-1")){
            teacherInfoQo.setStateId(null);
        }
        return teacherInfoMapper.showAllTeacher(teacherInfoQo);
    }



    @Override
    public int showAllTeacherCount(TeacherInfoQo teacherInfoQo) {

        if(teacherInfoQo.getTeacherName()==null || teacherInfoQo.getTeacherName().trim().isEmpty()){
            teacherInfoQo.setTeacherName(null);
        }
        if(teacherInfoQo.getTeacherNick()==null || teacherInfoQo.getTeacherNick().trim().isEmpty()){
            teacherInfoQo.setTeacherNick(null);
        }
        if(teacherInfoQo.getStateId()==null || teacherInfoQo.getStateId().equals("-1")){
            teacherInfoQo.setStateId(null);
        }



        return teacherInfoMapper.showAllTeacherCount(teacherInfoQo);
    }

    @Override
    public int adminAddTeacher(TeacherInfoQo teacherInfoQo) {
        if(teacherInfoQo.getTeacherName()==null || teacherInfoQo.getTeacherName().trim().isEmpty()){
            return -1;
        }
        if(teacherInfoQo.getTeacherNick()==null || teacherInfoQo.getTeacherNick().trim().isEmpty()){
            return -1;
        }
        return teacherInfoMapper.adminAddTeacher(teacherInfoQo);
    }

    @Override
    public int adminUpdateTeacher(TeacherInfoQo teacherInfoQo) {
        if(teacherInfoQo.getTeacherNick()==null || teacherInfoQo.getTeacherNick().trim().isEmpty()){
            return -1;
        }
        return teacherInfoMapper.adminUpdateTeacher(teacherInfoQo);
    }

    @Override
    public int adminLogOutTeacher(TeacherInfoQo teacherInfoQo) {
        return teacherInfoMapper.adminLogOutTeacher(teacherInfoQo);
    }

    @Override
    public int resetPwd(TeacherInfoQo teacherInfoQo) {
        return teacherInfoMapper.resetPwd(teacherInfoQo);
    }

    @Override
    public int updatePwd(TeacherInfoQo teacherInfoQo) {
        return teacherInfoMapper.updatePwd(teacherInfoQo);
    }
}
