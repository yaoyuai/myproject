package com.course.service.impl;

import com.course.mapper.MaterialInfoMapper;
import com.course.pojo.MaterialInfo;
import com.course.qo.MaterialInfoQo;
import com.course.service.MaterialInfoService;
import com.course.vo.MaterialInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialInfoServiceImpl implements MaterialInfoService {

    @Autowired
    private MaterialInfoMapper materialInfoMapper;

    @Override
    public int addMaterial(String []fileNameArr,String []fileUrlArr,String courseId,String teacherId) {
        int result=0;
        for(int i=0;i<fileNameArr.length;i++){
            MaterialInfoQo materialInfoQo=new MaterialInfoQo();
            materialInfoQo.setMaterialUrl(fileUrlArr[i]);
            materialInfoQo.setTeacherId(teacherId);
            materialInfoQo.setMaterialName(fileNameArr[i]);
            materialInfoQo.setCourseId(courseId);
            result=materialInfoMapper.addMaterial(materialInfoQo);
        }
        return result;
    }

    @Override
    public List<MaterialInfo> showAllMaterialById(MaterialInfoQo materialInfoQo) {
        return materialInfoMapper.showAllMaterialById(materialInfoQo);
    }

    @Override
    public List<MaterialInfoVo> showAllVideo(MaterialInfoQo materialInfoQo) {
        return materialInfoMapper.showAllVideo(materialInfoQo);
    }

    @Override
    public int showAllVideoCount(MaterialInfoQo materialInfoQo) {
        return materialInfoMapper.showAllVideoCount(materialInfoQo);
    }

    @Override
    public List<MaterialInfoVo> showAllMaterialByCourseId(MaterialInfoQo materialInfoQo) {
        return materialInfoMapper.showAllMaterialByCourseId(materialInfoQo);
    }

    @Override
    public int showAllMaterialByCourseIdCount(MaterialInfoQo materialInfoQo) {
        return materialInfoMapper.showAllMaterialByCourseIdCount(materialInfoQo);
    }
}
