package com.course.service.impl;

import com.course.mapper.ZcontentInfoMapper;
import com.course.mapper.ZexamresInfoMapper;
import com.course.pojo.ZexamresInfo;
import com.course.qo.ZcontentInfoQo;
import com.course.qo.ZexamresInfoQo;
import com.course.service.ZexamresInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZexamresInfoServiceImpl implements ZexamresInfoService {

    @Autowired
    private ZexamresInfoMapper zexamresInfoMapper;
    @Autowired
    private ZcontentInfoMapper zcontentInfoMapper;

    @Override
    public ZexamresInfo selectZexamHasResult(ZexamresInfoQo zexamresInfoQo) {
        return zexamresInfoMapper.selectZexamHasResult(zexamresInfoQo);
    }

    @Override
    public int addZexamResInfo(ZexamresInfoQo zexamresInfoQo) {
        if(zexamresInfoQo.getExamId()==null){
            return -1;
        }
        if(zexamresInfoQo.getStudentId()==null){
            return -1;
        }
        if(zexamresInfoQo.getZexamresScore()==null){
            return -1;
        }
        ZcontentInfoQo zcontentInfoQo=new ZcontentInfoQo();
        zcontentInfoQo.setExamId(zexamresInfoQo.getExamId());
        zcontentInfoQo.setStudentId(zexamresInfoQo.getStudentId());
        int result=zcontentInfoMapper.updateZcontentState(zcontentInfoQo);
        result=zexamresInfoMapper.addZexamResInfo(zexamresInfoQo);
        return result;
    }

    @Override
    public double selectZhuGuanScore(ZexamresInfoQo zexamresInfoQo) {
        return zexamresInfoMapper.selectZhuGuanScore(zexamresInfoQo);
    }
}
