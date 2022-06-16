package com.course.mapper;

import com.course.pojo.MaterialInfo;
import com.course.qo.MaterialInfoQo;
import com.course.vo.MaterialInfoVo;

import java.util.List;

public interface MaterialInfoMapper {
    int addMaterial(MaterialInfoQo materialInfoQo);

    //后台资料的查询
    List<MaterialInfo> showAllMaterialById(MaterialInfoQo materialInfoQo);

    //查询所有的视频
    List<MaterialInfoVo> showAllVideo(MaterialInfoQo materialInfoQo);

    //查询所有的视频数量
    int showAllVideoCount(MaterialInfoQo materialInfoQo);

    //查询所有的资料
    List<MaterialInfoVo> showAllMaterialByCourseId(MaterialInfoQo materialInfoQo);

    //查询所有的资料数量
    int showAllMaterialByCourseIdCount(MaterialInfoQo materialInfoQo);
}
