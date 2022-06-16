package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.pojo.TeacherInfo;
import com.course.qo.ExamInfoQo;
import com.course.qo.ZcontentInfoQo;
import com.course.service.ExamInfoService;
import com.course.vo.ExamInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ExamInfoController {

    @Autowired
    private ExamInfoService examInfoService;

    @RequestMapping("/exam/list")
    public String examList(ExamInfoQo examInfoQo,HttpSession session){
        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        examInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        List<ExamInfoVo> examInfoVoList = examInfoService.showAllExam(examInfoQo);
        int count=examInfoService.showAllExamCount(examInfoQo);
        return AjaxJsonDto.success("",examInfoVoList,count);
    }

    @RequestMapping("/exam/add")
    public String examAdd(@RequestBody ExamInfoQo examInfoQo, HttpSession session){
        if(examInfoService.selectHasExam(examInfoQo.getExamName(),examInfoQo.getCourseId())!=null){
            return AjaxJsonDto.fail("该课程已存在该考试，请重命名");
        }


        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        examInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        int result = examInfoService.addExam(examInfoQo);
        if(result>0){
            return AjaxJsonDto.success("添加成功");
        }
        return AjaxJsonDto.fail("添加失败");
    }

    @RequestMapping("/exam/update")
    public String examUpdate(@RequestBody ExamInfoQo examInfoQo){
        if(examInfoService.selectHasExam(examInfoQo.getExamName(),examInfoQo.getCourseId())!=null){
            return AjaxJsonDto.fail("该课程已存在该考试，请重命名");
        }
        int result=examInfoService.updateExam(examInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新成功");
        }
        return AjaxJsonDto.fail("更新失败");
    }


    @RequestMapping("/exam/delete")
    public String examDelete(@RequestBody ExamInfoQo examInfoQo){
        int result=examInfoService.deleteExam(examInfoQo);
        if(result>0){
            return AjaxJsonDto.success("删除成功");
        }
        return AjaxJsonDto.fail("删除失败");
    }


    @RequestMapping("/exam/select")
    public String examSelect(HttpSession session){
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("teacher");
        List<ExamInfoVo> examInfoVoList = examInfoService.selectAllExam(teacherInfo.getTeacherId() + "");
        return AjaxJsonDto.success("",examInfoVoList);
    }


    @RequestMapping("/exam/showexambyteacherid")
    public String examShowExamByTeacherId(HttpSession session){
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("teacher");
        ExamInfoQo examInfoQo=new ExamInfoQo();
        examInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        List<ExamInfoVo> examInfoVoList=examInfoService.showAllExamByTeacherId(examInfoQo);
        return AjaxJsonDto.success("",examInfoVoList);
    }


    @RequestMapping("/exam/showcoursebyexamid")
    public String examShowCourseByExamId(@RequestBody ExamInfoQo examInfoQo){

        List<ExamInfoVo> examInfoVoList=examInfoService.showAllExamByCourseId(examInfoQo);
        return AjaxJsonDto.success("",examInfoVoList);
    }
}
