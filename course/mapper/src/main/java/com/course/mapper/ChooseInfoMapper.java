package com.course.mapper;
import com.course.pojo.ChooseInfo;
import com.course.qo.ChooseInfoQo;
import com.course.vo.ChooseInfoVo;

import java.util.List;


public interface ChooseInfoMapper {
    int addChoose(ChooseInfoQo chooseInfoQo);

    List<ChooseInfoVo> showAllChooseInfoByExerId(String exerId);

    int selectMaxId();
}
