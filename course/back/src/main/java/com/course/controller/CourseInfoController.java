package com.course.controller;


import com.alibaba.fastjson.JSONObject;
import com.course.dto.AjaxJsonDto;
import com.course.dto.JsonDto;
import com.course.pojo.CouselInfo;
import com.course.pojo.TeacherInfo;
import com.course.qo.CourseInfoQo;
import com.course.qo.TeacherInfoQo;
import com.course.service.CourseInfoService;
import com.course.service.MaterialInfoService;
import com.course.utils.Tool;
import com.course.vo.CourseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class CourseInfoController {


    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private MaterialInfoService materialInfoService;



    @RequestMapping("/course/list")
    public String courseList(CourseInfoQo courseInfoQo){
        List<CourseInfoVo> courseInfoVoList = courseInfoService.adminShowAllCourse(courseInfoQo);
        int count=courseInfoService.adminShowAllCourseCount(courseInfoQo);
        return AjaxJsonDto.success("",courseInfoVoList,count);
    }


    @RequestMapping("/course/audit")
    public String courseAudit(@RequestBody String couseIdArr){
        String[] split = couseIdArr.replace("[", "").replace("]", "").split(",");

        for (String s : split) {
            System.out.println(s);
        }
        int result = courseInfoService.adminAuditCourse(split);
        if(result>0){
            return AjaxJsonDto.success("审核成功");
        }
        return AjaxJsonDto.fail("审核失败");
    }

    @RequestMapping("/course/uploadimg")
    public String courseUploadImg(MultipartFile image){
        System.out.println(image.getOriginalFilename()+"-----");
        //先判断大小和文件的
        String []fileNameArr=image.getOriginalFilename().split("\\.");
        String frontName="G:/desk/ideaProject/course/back/src/main/resources/static/upload/images";
        String fileName= UUID.randomUUID().toString();
        String outName=fileNameArr[fileNameArr.length-1];



        if(image.getSize()>=Tool.imgLen){
            return AjaxJsonDto.fail("课程封面不能超过1M");
        }

        if(!Tool.judgeHasImg(outName)){
            return AjaxJsonDto.fail("课程封面格式错误");
        }

        String dateName=Tool.getDate();
        String finalFileName=frontName+dateName+fileName+"."+outName;
        File file=new File(frontName+dateName);
        if(!file.exists()){
            file.mkdirs();
        }
        JsonDto jsonDto=new JsonDto();
        try {
            image.transferTo(new File(finalFileName));

            jsonDto.setId(1);
            jsonDto.setMessage("上传课程封面成功");
            jsonDto.getMap().put("imagePath","images"+dateName+fileName+"."+outName);
            return JSONObject.toJSONString(jsonDto);
        } catch (IOException e) {
            e.printStackTrace();
            jsonDto.setId(0);
            jsonDto.setMessage("上传课程封面失败");
            return JSONObject.toJSONString(jsonDto);
        }
    }

    @RequestMapping("/course/uploadfile")
    public String uploadFile(MultipartFile multipartFile){
        System.out.println("执行到了"+multipartFile.getOriginalFilename());
        String []fileNameArr=multipartFile.getOriginalFilename().split("\\.");
        String frontName="G:/desk/ideaProject/course/back/src/main/resources/static/upload/file";
        String fileName= UUID.randomUUID().toString();
        String outName=fileNameArr[fileNameArr.length-1];


        System.out.println(outName);
        JsonDto jsonDto=new JsonDto();


        String dateName=Tool.getDate();
        String finalFileName=frontName+dateName+fileName+"."+outName;
        File file=new File(frontName+dateName);
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            multipartFile.transferTo(new File(finalFileName));
            jsonDto.setId(1);
            jsonDto.setMessage("上传文件成功");
            jsonDto.getMap().put("filePath","file"+dateName+fileName+"."+outName);
            return JSONObject.toJSONString(jsonDto);
        } catch (IOException e) {
            e.printStackTrace();
            jsonDto.setId(0);
            jsonDto.setMessage("上传文件失败");
            return JSONObject.toJSONString(jsonDto);
        }
    }



    @RequestMapping("course/teacherlist")
    public String courseTeacherList(CourseInfoQo courseInfoQo, HttpSession session){

        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        courseInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        List<CourseInfoVo> courseInfoVoList = courseInfoService.teacherShowAllCourse(courseInfoQo);
        int count=courseInfoService.teacherShowAllCourseCount(courseInfoQo);
        return AjaxJsonDto.success("",courseInfoVoList,count);

    }

    @RequestMapping("course/teacherupdate")
    public String courseTeacherUpdate(@RequestBody CourseInfoQo courseInfoQo){
        System.out.println(courseInfoQo);
        int result = courseInfoService.teacherUpdateCourse(courseInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新课程成功");
        }
        return AjaxJsonDto.fail("更新课程失败");
    }

    @RequestMapping("course/teacherupdatestate")
    public String courseTeacherUpdateState(@RequestBody CourseInfoQo courseInfoQo){

        int result=courseInfoService.teacherUpdateCourseState(courseInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新课程状态成功");
        }
        return AjaxJsonDto.fail("更新课程状态失败");
    }


    @RequestMapping("course/addcourse")
    public String couseTeacherAddCourse(@RequestBody CourseInfoQo courseInfoQo,HttpSession session){
        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        courseInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        if (courseInfoService.selectTeacherHasCourseTwo(courseInfoQo)>0){
            return AjaxJsonDto.fail("课程已存在");
        }

        String[] fileUrlArr = courseInfoQo.getFilePath().split(",");
        String[] fileNameArr = courseInfoQo.getMaterialName().split(",");



        int result=courseInfoService.teacherUploadCourse(courseInfoQo);

        int courseId=courseInfoService.selectCourseMaxId();
        result=materialInfoService.addMaterial(fileNameArr,fileUrlArr,courseId+"",courseInfoQo.getTeacherId());
        if(result>0){

            return AjaxJsonDto.success("上传课程成功",courseId);
        }
        return AjaxJsonDto.fail("上传课程失败");
    }


    @RequestMapping("/course/auditno")
    public String courseAuditNo(@RequestBody String couseIdArr){
        String[] split = couseIdArr.replace("[", "").replace("]", "").split(",");

        for (String s : split) {
            System.out.println(s);
        }
        int result = courseInfoService.adminAuditNoCourse(split);
        if(result>0){
            return AjaxJsonDto.success("审核成功");
        }
        return AjaxJsonDto.fail("审核失败");
    }

    @RequestMapping("/course/needlist")
    public String courseNeedList(HttpSession session){
        TeacherInfo teacherInfo= (TeacherInfo) session.getAttribute("teacher");
        List<CourseInfoVo> courseInfoVoList = courseInfoService.showAllCourseByExamAndTrain(teacherInfo.getTeacherId() + "");
        return AjaxJsonDto.success("",courseInfoVoList);
    }


    @RequestMapping("/course/delete")
    public String courseDelete(@RequestBody CourseInfoQo courseInfoQo){

        int result=courseInfoService.deleteCourse(courseInfoQo);
        if(result>0){
            return AjaxJsonDto.success("删除成功");
        }
        return AjaxJsonDto.fail("删除失败");
    }

}
