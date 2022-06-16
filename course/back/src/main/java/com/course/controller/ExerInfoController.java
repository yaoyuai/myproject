package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.ExerInfo;
import com.course.qo.ExamInfoQo;
import com.course.qo.ExerInfoQo;
import com.course.service.ChooseInfoService;
import com.course.service.ExamInfoService;
import com.course.service.ExerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExerInfoController {
    @Autowired
    private ExerInfoService exerInfoService;
    @Autowired
    private ChooseInfoService chooseInfoService;
    @Autowired
    private ExamInfoService examInfoService;

//    @RequestMapping("/exer/uploadfile")
//    public String uploadFile(MultipartFile file){
//
//
//        return
//    }


    @RequestMapping("exer/add")
    public String exerAdd(@RequestBody  ExerInfoQo exerInfoQo){
        String[] split = exerInfoQo.getLastquestions().replace("[", "").replace("]", "").split(",");

        int result = exerInfoService.addExer(exerInfoQo);
        int exerId=exerInfoService.selectMaxExerId();
        if(!exerInfoQo.getTypeId().equals("4")){
            result= chooseInfoService.addChoose(split, exerId+"",exerInfoQo.getExerAnswer());
        }



        if(result>0){
            return AjaxJsonDto.success("添加题目成功");
        }
        return AjaxJsonDto.fail("添加题目失败");
    }



    @RequestMapping("exer/showexamhasexer")
    public String exerShowExamHasExer(@RequestBody ExerInfoQo exerInfoQo){

        if(exerInfoService.showExamHasExer(exerInfoQo)>0){
            ExamInfoQo examInfoQo=new ExamInfoQo();
            examInfoQo.setExamId(exerInfoQo.getExamId());
            int result=examInfoService.updateExamStateFabu(examInfoQo);
            if(result>0){
                return  AjaxJsonDto.success("发布成功");
            }
            return AjaxJsonDto.fail("发布失败");
        }

        return AjaxJsonDto.fail("该考试未添加题目，请快去题目添加页面添加");



    }
}
