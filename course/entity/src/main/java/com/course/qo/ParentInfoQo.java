package com.course.qo;


import lombok.Data;

@Data
public class ParentInfoQo extends PageQo{

    private String parentId;
    private String parentName;
    private String parentNick;
    private String parentPwd;
    private String stateId;
    private String parentCtime;
    private String parentMtime;
    private String roleId;
    private String code;

}
