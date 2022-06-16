package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.pojo.StudentInfo;
import com.course.pojo.TeacherInfo;
import com.course.qo.CommentInfoQo;
import com.course.service.CommentInfoService;
import com.course.vo.CommentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
public class CommentInfoController {
    @Autowired
    private CommentInfoService commentInfoService;


    @RequestMapping("/comment/add")
    public String commentAdd(@RequestBody CommentInfoQo commentInfoQo, HttpSession session){
        StudentInfo studentInfo = (StudentInfo) session.getAttribute("student");
        commentInfoQo.setStudentId(studentInfo.getStudentId()+"");
        int result=commentInfoService.addComment(commentInfoQo);
        if (result > 0) {
            return AjaxJsonDto.success("评论成功");
        }
        return AjaxJsonDto.fail("评论失败");
    }


    @RequestMapping("/comment/update")
    public String commentUpdate(@RequestBody CommentInfoQo commentInfoQo,HttpSession session){
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("teacher");
        commentInfoQo.setTeacherId(teacherInfo.getTeacherId()+"");
        int result=commentInfoService.updateComment(commentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("回复评论成功");
        }
        return AjaxJsonDto.fail("回复评论失败");
    }


    @RequestMapping("/comment/delete")
    public String commentDelete(@RequestBody CommentInfoQo commentInfoQo){
        String commentId=commentInfoQo.getCommentId();
        int result=commentInfoService.deleteComment(commentId);
        if(result>0){
            return AjaxJsonDto.success("删除评论成功");
        }
        return AjaxJsonDto.fail("删除评论失败");
    }

    @RequestMapping("/comment/list")
    public String commentList(CommentInfoQo commentInfoQo){
        List<CommentInfoVo> commentInfoVoList=commentInfoService.showAllComment(commentInfoQo);
        int count=commentInfoService.showAllCommentCount(commentInfoQo);
        return AjaxJsonDto.success("",commentInfoVoList,count);
    }
}
