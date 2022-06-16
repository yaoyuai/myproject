package com.course.service;

import com.course.pojo.ZexamresInfo;
import com.course.qo.ZexamresInfoQo;

public interface ZexamresInfoService {

    ZexamresInfo selectZexamHasResult(ZexamresInfoQo zexamresInfoQo);

    int addZexamResInfo(ZexamresInfoQo zexamresInfoQo);

    //查看已经批改的主观题分数
    double selectZhuGuanScore(ZexamresInfoQo zexamresInfoQo);
}
