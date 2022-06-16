package com.course.pojo;
import lombok.Data;
@Data
public class MenuInfo {

    private int menuId;//菜单id
    private String menuName;//菜单名称
    private int menuPid;//菜单上级id
    private String menuCtime;//菜单创建时间
    private String menuMtime;//菜单修改时间
    private String menuUrl;//菜单url
    private int stateId;//菜单状态id

}
