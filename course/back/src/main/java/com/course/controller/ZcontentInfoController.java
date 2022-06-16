package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.qo.ExerInfoQo;
import com.course.qo.KexamresInfoQo;
import com.course.qo.ZcontentInfoQo;
import com.course.service.ExerInfoService;
import com.course.service.KexamresInfoService;
import com.course.service.ZcontentInfoService;
import com.course.vo.ZcontentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class ZcontentInfoController {

    @Autowired
    private ZcontentInfoService zcontentInfoService;
    @Autowired
    private ExerInfoService exerInfoService;
    @Autowired
    private KexamresInfoService kexamresInfoService;

    @RequestMapping("/zcontent/showallzcontent")
    public String zcontentShowAllZcontent(ZcontentInfoQo zcontentInfoQo){
        List<ZcontentInfoVo> zcontentInfoVoList=zcontentInfoService.showAllZcontentByStudentId(zcontentInfoQo);
        Integer count=zcontentInfoService.showAllZcontentByStudentIdCount(zcontentInfoQo);
        int count2=0;
        if(count!=null){
            count2=count;
        }
        return AjaxJsonDto.success("",zcontentInfoVoList,count2);
    }


    @RequestMapping("/zcontent/showzcontentbystudentid")
    public String zcontentShowZcontentByStudentId(@RequestBody ZcontentInfoQo zcontentInfoQo){
        List<ZcontentInfoVo> zcontentInfoVoList=zcontentInfoService.showZcontentByStudentIdAndExamId(zcontentInfoQo);
        return AjaxJsonDto.success("",zcontentInfoVoList);
    }

    @RequestMapping("zcontent/judgehaszhuguan")
    public String judgeHasZhuGuan(@RequestBody ZcontentInfoQo zcontentInfoQo){
        int count=zcontentInfoService.judgeZhuguan(zcontentInfoQo);
//        if(count>0){//有主观题 的情况
//            return AjaxJsonDto.fail("");
//        }//没有主观题的情况
        ExerInfoQo exerInfoQo=new ExerInfoQo();
        exerInfoQo.setExamId(zcontentInfoQo.getExamId());
        Integer sumScore = exerInfoService.sumExamScore(exerInfoQo);
        System.out.println(sumScore+"总分");
        KexamresInfoQo kexamresInfoQo=new KexamresInfoQo();
        kexamresInfoQo.setExamSum(sumScore+"");
        kexamresInfoQo.setExamId(zcontentInfoQo.getExamId());
        Integer oneScore = kexamresInfoService.sumOneExamScore(kexamresInfoQo);
        List<Integer> integerList=kexamresInfoService.sumAllScore(kexamresInfoQo);
        integerList.add(sumScore);
        integerList.add(oneScore);


        return AjaxJsonDto.success("",integerList);
    }



    @RequestMapping("zcontent/studenthasoverexam")
    public String zcontentStudentHasOveerExam(@RequestBody ZcontentInfoQo zcontentInfoQo){
        int count=zcontentInfoService.judgeStudentHasExam(zcontentInfoQo);
        if(count>0){
            return AjaxJsonDto.success("学生已经考试");
        }
        return AjaxJsonDto.fail("学生还未考试");

    }


}
