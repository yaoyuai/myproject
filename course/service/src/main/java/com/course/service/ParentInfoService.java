package com.course.service;

import com.course.pojo.ParentInfo;
import com.course.qo.ParentInfoQo;
import com.course.vo.ParentInfoVo;

import java.util.List;

public interface ParentInfoService {

    ParentInfo judgeLogin(ParentInfoQo parentInfoQo);

    int userAddParent(ParentInfoQo parentInfoQo);


    ParentInfo judgeHasName(String parentName);

    List<ParentInfoVo> showAllParent(ParentInfoQo parentInfoQo);

    int showAllParentCount(ParentInfoQo parentInfoQo);

    int adminAddParent(ParentInfoQo parentInfoQo);

    int adminLogOutParent(ParentInfoQo parentInfoQo);

    int adminUpdateParent(ParentInfoQo parentInfoQo);

    int resetPwd(ParentInfoQo parentInfoQo);

    int updatePwd(ParentInfoQo parentInfoQo);
}
