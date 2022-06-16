package com.course.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AjaxJsonDto {
    private int id;//传输的接口 1表示成功 0表示失败
    private String message;//传输的字符串
    private String location;//传输的地址
    private Map<String, Object> map = new HashMap<>();//传输的数据和数量



    public static String success(String message,Object ...o){
        AjaxJsonDto ajaxJsonDto=new AjaxJsonDto();
        ajaxJsonDto.setId(1);
        if(o.length>=2){
            ajaxJsonDto.setMessage(message);
            ajaxJsonDto.getMap().put("list",o[0]);
            ajaxJsonDto.getMap().put("count",o[1]);
        }else{
            ajaxJsonDto.setMessage(message);
            ajaxJsonDto.getMap().put("list",o[0]);
        }

        return JSONObject.toJSONString(ajaxJsonDto);
    }

    public static String success(String message){
        AjaxJsonDto ajaxJsonDto=new AjaxJsonDto();
        ajaxJsonDto.setId(1);
        ajaxJsonDto.setMessage(message);
        return JSONObject.toJSONString(ajaxJsonDto);
    }

    public static String fail(String message){
        AjaxJsonDto ajaxJsonDto=new AjaxJsonDto();
        ajaxJsonDto.setId(0);
        ajaxJsonDto.setMessage(message);
        return JSONObject.toJSONString(ajaxJsonDto);
    }

}
