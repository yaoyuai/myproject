package com.course.service;


import com.course.pojo.MaterialInfo;
import com.course.qo.MaterialInfoQo;
import com.course.vo.MaterialInfoVo;

import java.util.List;

public interface MaterialInfoService {
    int addMaterial(String []fileNameArr,String []fileUrlArr,String courseId,String teacherId);

    List<MaterialInfo> showAllMaterialById(MaterialInfoQo materialInfoQo);

    List<MaterialInfoVo> showAllVideo(MaterialInfoQo materialInfoQo);

    int showAllVideoCount(MaterialInfoQo materialInfoQo);
    //查询所有的资料
    List<MaterialInfoVo> showAllMaterialByCourseId(MaterialInfoQo materialInfoQo);

    //查询所有的资料数量
    int showAllMaterialByCourseIdCount(MaterialInfoQo materialInfoQo);
}
