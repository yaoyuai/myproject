package com.course.mapper;

import com.course.pojo.ParentInfo;
import com.course.pojo.StudentInfo;
import com.course.qo.ParentInfoQo;
import com.course.vo.ParentInfoVo;

import java.util.List;

public interface ParentInfoMapper {
    //判断登录结果
    ParentInfo judgeLogin(ParentInfoQo parentInfoQo);

    //家长注册
    int userAddParent(ParentInfoQo parentInfoQo);

    //判断注册的时候是否有重复的名称
    ParentInfo judgeRegistHasName(String parentName);

    List<ParentInfoVo> showAllParent(ParentInfoQo parentInfoQo);

    int showAllParentCount(ParentInfoQo parentInfoQo);



    int adminAddParent(ParentInfoQo parentInfoQo);

    int adminLogOutParent(ParentInfoQo parentInfoQo);

    int adminUpdateParent(ParentInfoQo parentInfoQo);

    int resetPwd(ParentInfoQo parentInfoQo);

    int updatePwd(ParentInfoQo parentInfoQo);


}
