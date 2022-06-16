package com.course.service;
import com.course.pojo.AdminInfo;
import com.course.qo.AdminInfoQo;


public interface AdminInfoService {
    AdminInfo judgeLogin(AdminInfoQo adminInfoQo);
}
