package com.course.service.impl;

import com.course.mapper.ParentInfoMapper;
import com.course.pojo.ParentInfo;
import com.course.qo.ParentInfoQo;
import com.course.service.ParentInfoService;
import com.course.vo.ParentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentInfoServiceImpl implements ParentInfoService {


    @Autowired
    private ParentInfoMapper parentInfoMapper;

    @Override
    public ParentInfo judgeLogin(ParentInfoQo parentInfoQo) {


        if(parentInfoQo.getParentName()==null || parentInfoQo.getParentName().trim().isEmpty()){
            return null;
        }
        if(parentInfoQo.getParentPwd()==null || parentInfoQo.getParentPwd().trim().isEmpty()){
            return null;
        }
        return parentInfoMapper.judgeLogin(parentInfoQo);
    }

    @Override
    public int userAddParent(ParentInfoQo parentInfoQo) {

        if(parentInfoQo.getParentName()==null || parentInfoQo.getParentName().trim().isEmpty()){
            return 0;
        }
        if(parentInfoQo.getParentPwd()==null || parentInfoQo.getParentPwd().trim().isEmpty()){
            return 0;
        }
        if(parentInfoQo.getParentNick()==null || parentInfoQo.getParentNick().trim().isEmpty()){
            return 0;
        }
        return parentInfoMapper.userAddParent(parentInfoQo);
    }

    @Override
    public ParentInfo judgeHasName(String parentName) {
        return parentInfoMapper.judgeRegistHasName(parentName);
    }

    @Override
    public List<ParentInfoVo> showAllParent(ParentInfoQo parentInfoQo) {

        if(parentInfoQo.getParentName()==null || parentInfoQo.getParentName().trim().isEmpty()){
            parentInfoQo.setParentName(null);
        }
        if(parentInfoQo.getParentNick()==null || parentInfoQo.getParentNick().trim().isEmpty()){
            parentInfoQo.setParentNick(null);
        }
        if(parentInfoQo.getStateId()==null || parentInfoQo.getStateId().equals("-1")) {
            parentInfoQo.setStateId(null);
        }
        return parentInfoMapper.showAllParent(parentInfoQo);
    }

    @Override
    public int showAllParentCount(ParentInfoQo parentInfoQo) {
        if(parentInfoQo.getParentName()==null || parentInfoQo.getParentName().trim().isEmpty()){
            parentInfoQo.setParentName(null);
        }
        if(parentInfoQo.getParentNick()==null || parentInfoQo.getParentNick().trim().isEmpty()){
            parentInfoQo.setParentNick(null);
        }
        if(parentInfoQo.getStateId()==null || parentInfoQo.getStateId().equals("-1")) {
            parentInfoQo.setStateId(null);
        }
        return parentInfoMapper.showAllParentCount(parentInfoQo);
    }

    @Override
    public int adminAddParent(ParentInfoQo parentInfoQo) {

        if(parentInfoQo.getParentName()==null || parentInfoQo.getParentName().trim().isEmpty()){
            return -1;
        }
        if(parentInfoQo.getParentNick()==null || parentInfoQo.getParentNick().trim().isEmpty()){
            return -1;
        }

        return parentInfoMapper.adminAddParent(parentInfoQo);
    }

    @Override
    public int adminLogOutParent(ParentInfoQo parentInfoQo) {
        return parentInfoMapper.adminLogOutParent(parentInfoQo);
    }

    @Override
    public int adminUpdateParent(ParentInfoQo parentInfoQo) {
        if(parentInfoQo.getParentNick()==null || parentInfoQo.getParentNick().trim().isEmpty()){
           return -1;
        }
        return parentInfoMapper.adminUpdateParent(parentInfoQo);
    }

    @Override
    public int resetPwd(ParentInfoQo parentInfoQo) {
        return parentInfoMapper.resetPwd(parentInfoQo);
    }

    @Override
    public int updatePwd(ParentInfoQo parentInfoQo) {
        if(parentInfoQo.getParentPwd()==null || parentInfoQo.getParentPwd().trim().isEmpty()){
            return -1;
        }
        return parentInfoMapper.updatePwd(parentInfoQo);
    }
}
