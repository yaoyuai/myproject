package com.course.vo;


import com.course.pojo.MenuInfo;
import lombok.Data;

/**
 * 作者: 姚宇
 * 类名：MenuInfoVo
 * 作用：菜单的vo视图类
 */
@Data
public class MenuInfoVo extends MenuInfo {
    private String roleName;//角色名称
    private String roleMenuId;//菜单角色id
    private String roleId;//角色id
}
