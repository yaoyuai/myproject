package com.course.service.impl;

import com.course.mapper.MenuInfoMapper;
import com.course.service.MenuInfoService;
import com.course.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {


    @Autowired
    private MenuInfoMapper menuInfoMapper;
    @Override
    public List<MenuInfoVo> showAllMenu(int roleId) {
       return menuInfoMapper.selectAllMeunByRoleId(roleId);
    }
}
