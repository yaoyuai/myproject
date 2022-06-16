package com.course.service.impl;

import com.course.mapper.CououtInfoMapper;
import com.course.mapper.CouselInfoMapper;
import com.course.qo.CououtInfoQo;
import com.course.qo.CouselInfoQo;
import com.course.service.CououtInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CououtInfoServiceImpl implements CououtInfoService {

    @Autowired
    private CououtInfoMapper cououtInfoMapper;
    @Autowired
    private CouselInfoMapper couselInfoMapper;


    @Override
    public int addCouout(CououtInfoQo cououtInfoQo) {
        if(cououtInfoQo.getCourseId()==null){
            return -1;
        }
        if(cououtInfoQo.getStudentId()==null){
            return -1;
        }
        CouselInfoQo couselInfoQo=new CouselInfoQo();
        couselInfoQo.setStudentId(cououtInfoQo.getStudentId());
        couselInfoQo.setCourseId(cououtInfoQo.getCourseId());
        int result=couselInfoMapper.deleteCousel(couselInfoQo);
        result=cououtInfoMapper.addCouout(cououtInfoQo);
        return result;
    }
}
