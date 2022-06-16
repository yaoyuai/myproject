package com.course.mapper;

import com.course.pojo.CourseInfo;
import com.course.pojo.CouselInfo;
import com.course.qo.CourseInfoQo;
import com.course.vo.CourseInfoVo;

import java.util.List;

public interface CourseInfoMapper {

    //课程条件查询
    List<CourseInfoVo> showAllCourseByCondition(CourseInfoQo courseInfoQo);

    //课程条件查询记录数
    int showAllCourseByConditionCount(CourseInfoQo courseInfoQo);

    //查询热门课程
    List<CourseInfoVo> selectHotCourse();

    //查询教师是否有课程
    CourseInfo selectTeacherHasCourse(String teacherId);

    //管理员审核课程查询
    List<CourseInfoVo> adminShowAllCourse(CourseInfoQo courseInfoQo);

    //管理员审核课程的查询数量
    int adminShowAllCourseCount(CourseInfoQo courseInfoQo);


    //修改课程的状态
    int adminAuditCourse(String courseId);


    //教师查询课程信息
    List<CourseInfoVo> teacherShowAllCourse(CourseInfoQo courseInfoQo);

    //教师查询课程信息的记录数
    int teacherShowAllCourseCount(CourseInfoQo courseInfoQo);

    //教师更新课程
    int teacherUpdateCourse(CourseInfoQo courseInfoQo);

    //教师上下架课程
    int teacherUpdateCourseState(CourseInfoQo courseInfoQo);

    //教师上传课程
    int teacherUploadCourse(CourseInfoQo courseInfoQo);

    //查询刚刚上传的课程id
    int selectCourseMaxId();

    //审核不通过课程
    int adminAuditNoCourse(String courseId);

    //查询所有的课程（发布考试训练使用）
    List<CourseInfoVo> showAllCourseByExamAndTrain(String teacherId);

    //删除课程
    int deleteCourse(CourseInfoQo courseInfoQo);


    int selectTeacherHasCourseTwo(CourseInfoQo courseInfoQo);


    //更新选课次数
    int updateSelectNum(CourseInfoQo courseInfoQo);


}
