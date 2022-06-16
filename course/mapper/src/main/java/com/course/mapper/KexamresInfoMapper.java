package com.course.mapper;

import com.course.pojo.KexamresInfo;
import com.course.qo.KexamresInfoQo;

import java.util.List;

public interface KexamresInfoMapper {
    int addKexamResInfo(KexamresInfoQo kexamresInfoQo);

    KexamresInfo selectHasKexamInfo(KexamresInfoQo kexamresInfoQo);

    int countZuoDaNum(KexamresInfoQo kexamresInfoQo);

    //统计题的分数
    List<Integer> sumAllScore(KexamresInfoQo kexamresInfoQo);

    //统计单场考试的分数
    Integer sumOneExamScore(KexamresInfoQo kexamresInfoQo);
}
