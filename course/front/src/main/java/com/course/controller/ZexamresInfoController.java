package com.course.controller;


import com.course.dto.AjaxJsonDto;
import com.course.pojo.KexamresInfo;
import com.course.pojo.StudentInfo;
import com.course.pojo.ZexamresInfo;
import com.course.qo.ExerInfoQo;
import com.course.qo.KexamresInfoQo;
import com.course.qo.ZexamresInfoQo;
import com.course.service.ExerInfoService;
import com.course.service.KexamresInfoService;
import com.course.service.ZexamresInfoService;
import com.course.vo.ExerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ZexamresInfoController {

    @Autowired
    private ZexamresInfoService zexamresInfoService;
    @Autowired
    private ExerInfoService exerInfoService;
    @Autowired
    private KexamresInfoService kexamresInfoService;


    @RequestMapping("zexam/showscore")
    public String zexamShowScore(@RequestBody ZexamresInfoQo zexamresInfoQo, HttpSession session){
        //查看该该考试是否有主观题

        ExerInfoQo exerInfoQo=new ExerInfoQo();
        exerInfoQo.setExamId(zexamresInfoQo.getExamId());
        List<ExerInfoVo> exerInfoVoList = exerInfoService.selectOneExamHasTianKong(exerInfoQo);
        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");



        KexamresInfoQo kexamresInfoQo=new KexamresInfoQo();
        kexamresInfoQo.setExamId(zexamresInfoQo.getExamId());
        kexamresInfoQo.setStudentId(studentInfo.getStudentId()+"");
        KexamresInfo kexamresInfo = kexamresInfoService.selectHasKexamInfo(kexamresInfoQo);



        if(exerInfoVoList!=null && exerInfoVoList.size()!=0){
            zexamresInfoQo.setStudentId(studentInfo.getStudentId()+"");
            ZexamresInfo zexamresInfo=zexamresInfoService.selectZexamHasResult(zexamresInfoQo);
            if(zexamresInfo==null){
                return AjaxJsonDto.fail("主观题教师暂未评分");
            }
            return AjaxJsonDto.success("当前考试成绩为:"+(kexamresInfo.getKexamresScore()+zexamresInfo.getZexamresScore())+"分");
       }else{
           return AjaxJsonDto.success("当前考试成绩为:"+kexamresInfo.getKexamresScore()+"分");
        }
    }


}
