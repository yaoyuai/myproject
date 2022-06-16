package com.course.controller;

import com.course.dto.AjaxJsonDto;
import com.course.qo.MaterialInfoQo;
import com.course.service.MaterialInfoService;
import com.course.vo.MaterialInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MaterialInfoController {

    @Autowired
    private MaterialInfoService materialInfoService;


    @RequestMapping("/material/getvideoinfo")
    public String materialGetVideoInfo(@RequestBody MaterialInfoQo materialInfoQo){
        List<MaterialInfoVo> materialInfoVoList=materialInfoService.showAllVideo(materialInfoQo);
        int count=materialInfoService.showAllVideoCount(materialInfoQo);
        return AjaxJsonDto.success("",materialInfoVoList,count);
    }


    @RequestMapping("/material/getmaterial")
    public String materialGetMaterial(@RequestBody MaterialInfoQo materialInfoQo){
        List<MaterialInfoVo> materialInfoVoList=materialInfoService.showAllMaterialByCourseId(materialInfoQo);
        int count=materialInfoService.showAllMaterialByCourseIdCount(materialInfoQo);
        return AjaxJsonDto.success("",materialInfoVoList,count);
    }

}
