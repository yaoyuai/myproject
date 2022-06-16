package com.course.controller;
import com.course.dto.AjaxJsonDto;
import com.course.qo.ZexamresInfoQo;
import com.course.service.ZexamresInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZexamresInfoController {
    @Autowired
    private ZexamresInfoService zexamresInfoService;

    @RequestMapping("/zexamres/add")
    public String zexamresAdd(@RequestBody ZexamresInfoQo zexamresInfoQo){
        int result=zexamresInfoService.addZexamResInfo(zexamresInfoQo);
        if(result>0){
            return AjaxJsonDto.success("评分成功");
        }
        return AjaxJsonDto.fail("评分失败");
    }


    @RequestMapping("/zexamres/showscore")
    public String zexamresShowScore(@RequestBody ZexamresInfoQo zexamresInfoQo){
        double score=zexamresInfoService.selectZhuGuanScore(zexamresInfoQo);
        return AjaxJsonDto.success("",score);
    }
}
