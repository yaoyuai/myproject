package com.course.mapper;

import com.course.vo.MenuInfoVo;

import java.util.List;

public interface MenuInfoMapper {
    List<MenuInfoVo> selectAllMeunByRoleId(int roleId);
}
