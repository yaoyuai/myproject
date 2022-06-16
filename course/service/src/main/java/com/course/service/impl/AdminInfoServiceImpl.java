package com.course.service.impl;

import com.course.mapper.AdminInfoMapper;
import com.course.pojo.AdminInfo;
import com.course.qo.AdminInfoQo;
import com.course.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo judgeLogin(AdminInfoQo adminInfoQo) {

        if(adminInfoQo.getAdminName()==null || adminInfoQo.getAdminPwd().trim().isEmpty()){
            return null;
        }
        if(adminInfoQo.getAdminPwd()==null || adminInfoQo.getAdminPwd().trim().isEmpty()){
            return null;
        }
        return adminInfoMapper.judgeLogin(adminInfoQo);
    }
}
