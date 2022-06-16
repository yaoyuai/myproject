package com.course.pojo;


import lombok.Data;
@Data
public class RoleInfo {

    private int roleId;//角色id
    private String roleName;//角色名称
    private String roleCtime;//角色创建时间
    private String roleMtime;//角色修改时间
    private int stateId;//状态id

}
