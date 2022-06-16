package com.course.pojo;

import lombok.Data;

@Data
public class RoleMenuRel {

    private int roleMenuId;//菜单角色关系id
    private int roleId;//角色id
    private int menuId;//菜单id
}
