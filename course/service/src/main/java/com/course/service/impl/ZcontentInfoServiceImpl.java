package com.course.service.impl;

import com.course.mapper.ZcontentInfoMapper;
import com.course.qo.ZcontentInfoQo;
import com.course.service.ZcontentInfoService;
import com.course.vo.ZcontentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZcontentInfoServiceImpl implements ZcontentInfoService {

    @Autowired
    private ZcontentInfoMapper zcontentInfoMapper;
    @Override
    public int addZcontentInfo(ZcontentInfoQo zcontentInfoQo) {
        if(zcontentInfoQo.getZcontentAnswer()==null || zcontentInfoQo.getZcontentAnswer().trim().isEmpty()){
            return -1;
        }
        if(zcontentInfoQo.getStudentId()==null){
            return -1;
        }
        if(zcontentInfoQo.getExamId()==null){
            return -1;
        }
        if(zcontentInfoQo.getExerId()==null){
            return -1;
        }
        return zcontentInfoMapper.addZcontentInfo(zcontentInfoQo);
    }

    @Override
    public List<ZcontentInfoVo> showAllZcontentByStudentId(ZcontentInfoQo zcontentInfoQo) {
        System.out.println(zcontentInfoQo.getExamId()+"考试id");
        if(zcontentInfoQo.getExamId()==null || zcontentInfoQo.getExamId().equals("")){
            zcontentInfoQo.setExamId(null);
        }
        return zcontentInfoMapper.showAllZcontentByStudentId(zcontentInfoQo);
    }

    @Override
    public Integer showAllZcontentByStudentIdCount(ZcontentInfoQo zcontentInfoQo) {
        if(zcontentInfoQo.getExamId()==null || zcontentInfoQo.getExamId().equals("")){
            zcontentInfoQo.setExamId(null);
        }
        return zcontentInfoMapper.showAllZcontentByStudentIdCount(zcontentInfoQo);
    }

    @Override
    public List<ZcontentInfoVo> showZcontentByStudentIdAndExamId(ZcontentInfoQo zcontentInfoQo) {
        return zcontentInfoMapper.showZcontentByStudentIdAndExamId(zcontentInfoQo);
    }

    @Override
    public int updateZcontentState(ZcontentInfoQo zcontentInfoQo) {
        if(zcontentInfoQo.getExamId()==null){
            return -1;
        }
        if(zcontentInfoQo.getStudentId()==null){
            return -1;
        }
        return zcontentInfoMapper.updateZcontentState(zcontentInfoQo);
    }

    @Override
    public int judgeZhuguan(ZcontentInfoQo zcontentInfoQo) {
        return zcontentInfoMapper.judgeZhuguan(zcontentInfoQo);
    }


    @Override
    public int judgeStudentHasExam(ZcontentInfoQo zcontentInfoQo) {
        return zcontentInfoMapper.judgeStudentHasExam(zcontentInfoQo);
    }
}
