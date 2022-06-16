package com.course.service.impl;

import com.course.mapper.ChooseInfoMapper;
import com.course.mapper.ExerInfoMapper;
import com.course.pojo.ChooseInfo;
import com.course.pojo.ExerInfo;
import com.course.qo.ExerInfoQo;
import com.course.service.ExerInfoService;
import com.course.vo.ChooseInfoVo;
import com.course.vo.ExamInfoVo;
import com.course.vo.ExerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerInfoServiceImpl implements ExerInfoService {

    @Autowired
    private ExerInfoMapper exerInfoMapper;
    @Autowired
    private ChooseInfoMapper chooseInfoMapper;


    @Override
    public int addExer(ExerInfoQo exerInfoQo) {
//        if(exerInfoQo.getExerAnaly()==null || exerInfoQo.getExerAnaly().trim().isEmpty()){
//            return -1;
//        }
        if(exerInfoQo.getTypeId().equals("4")){
            if(exerInfoQo.getExerContent()==null || exerInfoQo.getExerContent().trim().isEmpty()){
                return -1;
            }
            if(exerInfoQo.getExerValue()==null || exerInfoQo.getExerValue().trim().isEmpty()){
                return -1;
            }
            if(exerInfoQo.getTypeId()==null){
                return -1;
            }
        }else{
            if (exerInfoQo.getExerAnswer()==null || exerInfoQo.getExerAnswer().trim().isEmpty()){
                return -1;
            }
            if(exerInfoQo.getExerContent()==null || exerInfoQo.getExerContent().trim().isEmpty()){
                return -1;
            }
            if(exerInfoQo.getExerValue()==null || exerInfoQo.getExerValue().trim().isEmpty()){
                return -1;
            }
            if(exerInfoQo.getTypeId()==null){
                return -1;
            }
        }

        if(exerInfoQo.getExamId()==null) {
            exerInfoQo.setExamId(null);
        }
        if(exerInfoQo.getTrainId()==null){
            exerInfoQo.setTrainId(null);
        }
        return exerInfoMapper.addExer(exerInfoQo);
    }

    @Override
    public int selectMaxExerId() {
        return exerInfoMapper.selectMaxExerId();
    }

    @Override
    public List<ExerInfoVo> showAllExerByExamId(ExerInfoQo exerInfoQo) {

        List<ExerInfoVo> exerInfoVoList=exerInfoMapper.showAllExerByExamId(exerInfoQo);
        //根据每一道题目遍历其答案
        for (ExerInfoVo exerInfoVo : exerInfoVoList) {
            List<ChooseInfoVo> chooseInfoVoList=chooseInfoMapper.showAllChooseInfoByExerId(exerInfoVo.getExerId()+"");
            exerInfoVo.setChooseInfoVoList(chooseInfoVoList);
        }
        return exerInfoVoList;
    }

    @Override
    public List<ExerInfoVo> selectOneExamHasTianKong(ExerInfoQo exerInfoQo) {
        return exerInfoMapper.selectOneExamHasTianKong(exerInfoQo);
    }

    @Override
    public List<ExerInfoVo> showAllExerByTrainId(ExerInfoQo exerInfoQo) {
        List<ExerInfoVo> exerInfoVoList=exerInfoMapper.showAllExerByTrainId(exerInfoQo);
        //根据每一道题目遍历其答案
        for (ExerInfoVo exerInfoVo : exerInfoVoList) {
            List<ChooseInfoVo> chooseInfoVoList=chooseInfoMapper.showAllChooseInfoByExerId(exerInfoVo.getExerId()+"");
            exerInfoVo.setChooseInfoVoList(chooseInfoVoList);
        }
        return exerInfoVoList;
    }

    @Override
    public Integer sumExamScore(ExerInfoQo exerInfoQo) {
        return exerInfoMapper.sumExamScore(exerInfoQo);
    }

    @Override
    public int updateAnswer(ExerInfoQo exerInfoQo) {
        return exerInfoMapper.updateAnswer(exerInfoQo);
    }

    @Override
    public int showExamHasExer(ExerInfoQo exerInfoQo) {
        return exerInfoMapper.showExamHasExer(exerInfoQo);
    }
}
