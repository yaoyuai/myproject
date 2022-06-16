package com.course.controller;

import com.course.dto.AjaxJsonDto;
import com.course.pojo.AdminInfo;
import com.course.pojo.ParentInfo;
import com.course.qo.ParentInfoQo;
import com.course.service.ParentInfoService;
import com.course.service.StudentInfoService;
import com.course.vo.ParentInfoVo;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ParentInfoController {

    @Autowired
    private ParentInfoService parentInfoService;
    @Autowired
    private StudentInfoService studentInfoService;


    @RequestMapping("/parent/login")
    public String parentLogin(@RequestBody ParentInfoQo parentInfoQo, HttpSession session){
        String code=parentInfoQo.getCode();
        if(!code.equalsIgnoreCase(String.valueOf(session.getAttribute("code")))){
            return AjaxJsonDto.fail("验证码输入错误");
        }
        ParentInfo parentInfo = parentInfoService.judgeLogin(parentInfoQo);
        if(parentInfo!=null){
            session.setAttribute("parent",parentInfo);
            return AjaxJsonDto.success("登录成功",parentInfo);
        }
        return AjaxJsonDto.fail("登录失败,账号密码有误");
    }



    @RequestMapping("parent/regist")
    public String parentRegist(@RequestBody ParentInfoQo parentInfoQo){
        //要先去查询一下有没有这个用户
        if(parentInfoService.judgeHasName(parentInfoQo.getParentName())!=null){
            return AjaxJsonDto.fail("该账户已被注册");
        }
        int result = parentInfoService.userAddParent(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注册成功，请前往登录");
        }
        return AjaxJsonDto.fail("注册失败，请联系管理员");
    }


    @RequestMapping("parent/add")
    public String parentAdd(@RequestBody ParentInfoQo parentInfoQo){
        if(parentInfoService.judgeHasName(parentInfoQo.getParentName())!=null){
            return AjaxJsonDto.fail("该用户名已存在,请重新输入");
        }
        int result=parentInfoService.adminAddParent(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("添加成功");
        }
        return  AjaxJsonDto.fail("添加失败");
    }

    @RequestMapping("parent/update")
    public String parentUpdate(@RequestBody ParentInfoQo parentInfoQo){

        int result=parentInfoService.adminUpdateParent(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新成功");
        }
        return AjaxJsonDto.fail("更新失败");
    }


    @RequestMapping("parent/logout")
    public String parentLogOut(@RequestBody ParentInfoQo parentInfoQo){
        if(studentInfoService.selectParentHasStudent(parentInfoQo.getParentId())!=null){
            return AjaxJsonDto.fail("该家长已绑定学生，不可注销");
        }
        int result=parentInfoService.adminLogOutParent(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("注销成功");
        }
        return AjaxJsonDto.fail("注销失败");
    }


    @RequestMapping("parent/list")
    public String parentList(ParentInfoQo parentInfoQo){
        List<ParentInfoVo> parentInfoVoList = parentInfoService.showAllParent(parentInfoQo);
        int count=parentInfoService.showAllParentCount(parentInfoQo);
        return AjaxJsonDto.success("",parentInfoVoList,count);
    }

    @RequestMapping("parent/resetpwd")
    public String parentResetPwd(ParentInfoQo parentInfoQo){
        int result=parentInfoService.resetPwd(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("重置密码成功");
        }
        return AjaxJsonDto.fail("重置密码失败");
    }


    @RequestMapping("parent/updatepwd")
    public String parentUpdatePwd(@RequestBody ParentInfoQo parentInfoQo){
        int result=parentInfoService.updatePwd(parentInfoQo);
        if(result>0){
            return AjaxJsonDto.success("更新密码成功，请重新登录");
        }
        return AjaxJsonDto.fail("更新密码失败");
    }
}
