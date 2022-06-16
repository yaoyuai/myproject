package com.course.mapper;
import com.course.pojo.AdminInfo;
import com.course.qo.AdminInfoQo;

public interface AdminInfoMapper {
    //判断管理员登录的方法
    AdminInfo judgeLogin(AdminInfoQo adminInfoQo);
}
