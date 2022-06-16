package com.course.service.impl;

import com.course.mapper.CourseInfoMapper;
import com.course.pojo.CourseInfo;
import com.course.qo.CourseInfoQo;
import com.course.service.CourseInfoService;
import com.course.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Override
    public List<CourseInfoVo> showAllCourseByCondition(CourseInfoQo courseInfoQo) {

        if(courseInfoQo.getCourseDes()==null || courseInfoQo.getCourseDes().isEmpty()){
            courseInfoQo.setCourseDes("");
        }
        return courseInfoMapper.showAllCourseByCondition(courseInfoQo);
    }

    @Override
    public int showAllCourseByConditionCount(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseDes()==null || courseInfoQo.getCourseDes().isEmpty()){
            courseInfoQo.setCourseDes("");
        }
        return courseInfoMapper.showAllCourseByConditionCount(courseInfoQo);
    }

    @Override
    public List<CourseInfoVo> selectHotCourse() {
        return courseInfoMapper.selectHotCourse();
    }

    @Override
    public CourseInfo selectTeacherHasCourse(String teacherId) {
        return courseInfoMapper.selectTeacherHasCourse(teacherId);
    }

    @Override
    public List<CourseInfoVo> adminShowAllCourse(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            courseInfoQo.setCourseName(null);
        }
        if(courseInfoQo.getTeacherName()==null || courseInfoQo.getTeacherName().trim().isEmpty()){
            courseInfoQo.setTeacherName(null);
        }
        if(courseInfoQo.getStateId()==null || courseInfoQo.getStateId().equals("-1")){
            courseInfoQo.setStateId(null);
        }
        return courseInfoMapper.adminShowAllCourse(courseInfoQo);
    }

    @Override
    public int adminShowAllCourseCount(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            courseInfoQo.setCourseName(null);
        }
        if(courseInfoQo.getTeacherName()==null || courseInfoQo.getTeacherName().trim().isEmpty()){
            courseInfoQo.setTeacherName(null);
        }
        if(courseInfoQo.getStateId()==null || courseInfoQo.getStateId().equals("-1")){
            courseInfoQo.setStateId(null);
        }
        return courseInfoMapper.adminShowAllCourseCount(courseInfoQo);
    }

    @Override
    public int adminAuditCourse(String []courseIdArr) {
        int result=0;
        for (String s : courseIdArr) {
            result=courseInfoMapper.adminAuditCourse(s);
            if(result<=0){
                return -1;
            }
        }
        return result;
    }

    @Override
    public List<CourseInfoVo> teacherShowAllCourse(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            courseInfoQo.setCourseName(null);
        }
        if(courseInfoQo.getCourseCtime()==null || courseInfoQo.getCourseCtime().trim().isEmpty()){
            courseInfoQo.setCourseCtime(null);
        }
        if(courseInfoQo.getStateId()==null || courseInfoQo.getStateId().equals("-1")){
            courseInfoQo.setStateId(null);
        }
        return courseInfoMapper.teacherShowAllCourse(courseInfoQo);
    }

    @Override
    public int teacherShowAllCourseCount(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            courseInfoQo.setCourseName(null);
        }
        if(courseInfoQo.getCourseCtime()==null || courseInfoQo.getCourseCtime().trim().isEmpty()){
            courseInfoQo.setCourseCtime(null);
        }
        if(courseInfoQo.getStateId()==null || courseInfoQo.getStateId().equals("-1")){
            courseInfoQo.setStateId(null);
        }

        return courseInfoMapper.teacherShowAllCourseCount(courseInfoQo);
    }

    @Override
    public int teacherUpdateCourse(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            return -1;
        }
        if(courseInfoQo.getCourseDes()==null || courseInfoQo.getCourseDes().trim().isEmpty()){
            return -1;
        }
        if(courseInfoQo.getCourseImg()==null){
            return -1;
        }
        return courseInfoMapper.teacherUpdateCourse(courseInfoQo);
    }

    @Override
    public int teacherUpdateCourseState(CourseInfoQo courseInfoQo) {
        return courseInfoMapper.teacherUpdateCourseState(courseInfoQo);
    }

    @Override
    public int teacherUploadCourse(CourseInfoQo courseInfoQo) {
        if(courseInfoQo.getCourseName()==null || courseInfoQo.getCourseName().trim().isEmpty()){
            return -1;
        }
        if(courseInfoQo.getCourseDes()==null || courseInfoQo.getCourseDes().trim().isEmpty()){
            return -1;
        }
        if(courseInfoQo.getCourseImg()==null){
            return -1;
        }
        return courseInfoMapper.teacherUploadCourse(courseInfoQo);
    }


    @Override
    public int selectCourseMaxId() {
        return courseInfoMapper.selectCourseMaxId();
    }

    @Override
    public int adminAuditNoCourse(String []courseIdArr) {
        int result=0;
        for (String s : courseIdArr) {
            result=courseInfoMapper.adminAuditNoCourse(s);
            if(result<=0){
                return -1;
            }
        }
        return result;
    }

    @Override
    public List<CourseInfoVo> showAllCourseByExamAndTrain(String teacherId) {
        return courseInfoMapper.showAllCourseByExamAndTrain(teacherId);
    }

    @Override
    public int deleteCourse(CourseInfoQo courseInfoQo) {
        return courseInfoMapper.deleteCourse(courseInfoQo);
    }

    @Override
    public int selectTeacherHasCourseTwo(CourseInfoQo courseInfoQo) {
        return courseInfoMapper.selectTeacherHasCourseTwo(courseInfoQo);
    }

    @Override
    public int updateSelectNum(CourseInfoQo courseInfoQo) {
        return courseInfoMapper.updateSelectNum(courseInfoQo);
    }
}
