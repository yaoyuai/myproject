package com.course.mapper;


import com.course.pojo.ZexamresInfo;
import com.course.qo.ZexamresInfoQo;

public interface ZexamresInfoMapper {
    ZexamresInfo selectZexamHasResult(ZexamresInfoQo zexamresInfoQo);

    int addZexamResInfo(ZexamresInfoQo zexamresInfoQo);

    //查看已经批改的主观题分数
    int selectZhuGuanScore(ZexamresInfoQo zexamresInfoQo);

}
