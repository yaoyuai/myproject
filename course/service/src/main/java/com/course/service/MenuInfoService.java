package com.course.service;

import com.course.vo.MenuInfoVo;

import java.util.List;

public interface MenuInfoService {
    List<MenuInfoVo> showAllMenu(int roleId);
}
