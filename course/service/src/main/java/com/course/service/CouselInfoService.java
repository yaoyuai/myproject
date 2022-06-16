package com.course.service;

import com.course.pojo.CourseInfo;
import com.course.pojo.CouselInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.CouselInfoQo;
import com.course.qo.KexamresInfoQo;
import com.course.vo.CourseInfoVo;

import java.util.List;

public interface CouselInfoService {

    CourseInfo selectStudentHasSel(String studentId);

    //查询是否有选过这个课
    CouselInfo selectStudentHasCourse(CouselInfoQo couselInfoQo);

    //添加选课
    int addCousel(CouselInfoQo couselInfoQo);

    //删除选课
    int deleteCousel(CouselInfoQo couselInfoQo);

    //根据选课来查找到对应的课程
    List<CourseInfoVo> showCourseByCousel(CouselInfoQo couselInfoQo);

    //根据课程查询选课人数
    int selectCouselNum(CouselInfoQo couselInfoQo);


}
