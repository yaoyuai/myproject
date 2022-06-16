package com.course.service.impl;

import com.course.mapper.StudentInfoMapper;
import com.course.pojo.StudentInfo;
import com.course.qo.StudentInfoQo;
import com.course.service.StudentInfoService;
import com.course.vo.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;



    @Override
    public StudentInfo judgeLogin(StudentInfoQo studentInfoQo) {

        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().equals("")){
            return null;
        }
        if(studentInfoQo.getStudentPwd()==null || studentInfoQo.getStudentPwd().trim().equals("")){
            return null;
        }

        return studentInfoMapper.judgeLogin(studentInfoQo);
    }

    @Override
    public int addStudent(StudentInfoQo studentInfoQo) {

        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().equals("")){
            studentInfoQo.setStudentName(null);
        }
        if(studentInfoQo.getStudentPwd()==null || studentInfoQo.getStudentPwd().trim().equals("")){
            studentInfoQo.setStudentPwd(null);
        }
        if(studentInfoQo.getStudentNick()==null || studentInfoQo.getStudentNick().trim().equals("")){
            studentInfoQo.setStudentNick(null);
        }
        return studentInfoMapper.addStudent(studentInfoQo);
    }

    @Override
    public StudentInfo judgeRegistHasName(String studentName) {
        return studentInfoMapper.judgeRegistHasName(studentName);
    }

    @Override
    public List<StudentInfoVo> showAllStudent(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().isEmpty()){
            studentInfoQo.setStudentName(null);
        }
        if(studentInfoQo.getStudentNick()==null || studentInfoQo.getStudentNick().trim().isEmpty()){
            studentInfoQo.setStudentNick(null);
        }
        if(studentInfoQo.getStateId()==null || studentInfoQo.getStateId().equals("-1")){
            studentInfoQo.setStateId(null);
        }
        return studentInfoMapper.showAllStudent(studentInfoQo);
    }

    @Override
    public int showAllStudentCount(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().isEmpty()){
            studentInfoQo.setStudentName(null);
        }
        if(studentInfoQo.getStudentNick()==null || studentInfoQo.getStudentNick().trim().isEmpty()){
            studentInfoQo.setStudentNick(null);
        }
        if(studentInfoQo.getStateId()==null || studentInfoQo.getStateId().equals("-1")){
            studentInfoQo.setStateId(null);
        }
        return studentInfoMapper.showAllStudentCount(studentInfoQo);
    }

    @Override
    public int adminAddStudent(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().isEmpty()){
           return -1;
        }
        if(studentInfoQo.getStudentNick()==null || studentInfoQo.getStudentNick().trim().isEmpty()){
            return -1;
        }
        if(studentInfoQo.getStudentSex()==null){
            return -1;
        }
        return studentInfoMapper.adminAddStudent(studentInfoQo);
    }

    @Override
    public int adminUpdateStudent(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentNick()==null || studentInfoQo.getStudentNick().trim().isEmpty()){
            return -1;
        }
        if(studentInfoQo.getStudentSex()==null || studentInfoQo.getStudentNick().trim().isEmpty()){
            return -1;
        }
        return studentInfoMapper.adminUpdateStudent(studentInfoQo);
    }

    @Override
    public int adminLogOutStudent(StudentInfoQo studentInfoQo) {
        return studentInfoMapper.adminLogOutStudent(studentInfoQo);
    }

    @Override
    public StudentInfo selectParentHasStudent(String parentId) {
        return studentInfoMapper.selectParentHasStudent(parentId);
    }

    @Override
    public int resetPwd(StudentInfoQo studentInfoQo) {
        return studentInfoMapper.resetPwd(studentInfoQo);
    }

    @Override
    public List<StudentInfoVo> showBan(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentSex()==null || studentInfoQo.getStudentSex().equals("") || studentInfoQo.getStudentSex().equals("全部")){
            studentInfoQo.setStudentSex(null);
        }
        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().isEmpty()){
            studentInfoQo.setStudentName(null);
        }
        return studentInfoMapper.showBan(studentInfoQo);
    }

    @Override
    public int showBanCount(StudentInfoQo studentInfoQo) {
        if(studentInfoQo.getStudentSex()==null ||studentInfoQo.getStudentSex().equals("") || studentInfoQo.getStudentSex().equals("全部")){
            studentInfoQo.setStudentSex(null);
        }
        if(studentInfoQo.getStudentName()==null || studentInfoQo.getStudentName().trim().isEmpty()){
            studentInfoQo.setStudentName(null);
        }
        return studentInfoMapper.showBanCount(studentInfoQo);
    }

    @Override
    public int ban(StudentInfoQo studentInfoQo) {
        return studentInfoMapper.ban(studentInfoQo);
    }

    @Override
    public int jieBan(StudentInfoQo studentInfoQo) {
        return studentInfoMapper.jieBan(studentInfoQo);
    }

    @Override
    public List<StudentInfoVo> showStudentByParentId(StudentInfoQo studentInfoQo) {
        return studentInfoMapper.showStudentByParentId(studentInfoQo);
    }
}
