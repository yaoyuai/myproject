package com.course.service.impl;

import com.course.mapper.CouselInfoMapper;
import com.course.pojo.CourseInfo;
import com.course.pojo.CouselInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.CouselInfoQo;
import com.course.qo.KexamresInfoQo;
import com.course.service.CourseInfoService;
import com.course.service.CouselInfoService;
import com.course.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouselInfoServiceImpl implements CouselInfoService {


    @Autowired
    private CouselInfoMapper couselInfoMapper;
    @Override
    public CourseInfo selectStudentHasSel(String studentId) {
        return couselInfoMapper.selectStudentHasSel(studentId);
    }

    @Override
    public CouselInfo selectStudentHasCourse(CouselInfoQo couselInfoQo) {
        return couselInfoMapper.selectStudentHasCourse(couselInfoQo);
    }

    @Override
    public int addCousel(CouselInfoQo couselInfoQo) {
        if(couselInfoQo.getCourseId()==null){
            return -1;
        }
        if(couselInfoQo.getStudentId()==null){
            return -1;
        }
        return couselInfoMapper.addCousel(couselInfoQo);
    }

    @Override
    public int deleteCousel(CouselInfoQo couselInfoQo) {
        if(couselInfoQo.getCouselId()==null){
            return -1;
        }
        return couselInfoMapper.deleteCousel(couselInfoQo);
    }

    @Override
    public List<CourseInfoVo> showCourseByCousel(CouselInfoQo couselInfoQo) {
        return couselInfoMapper.showCourseByCousel(couselInfoQo);
    }


    @Override
    public int selectCouselNum(CouselInfoQo couselInfoQo) {
        return couselInfoMapper.selectCouselNum(couselInfoQo);
    }


}
