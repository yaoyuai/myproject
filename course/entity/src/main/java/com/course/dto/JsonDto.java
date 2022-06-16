package com.course.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者: 姚宇
 * 类名：JsonDto
 * 作用：传输对象，用来存放传递的信息
 */
@Data
public class JsonDto {
    private int id;//传输的接口 1表示成功 0表示失败
    private String message;//传输的字符串
    private String location;//传输的地址
    private Map<String, Object> map = new HashMap<>();//传输的数据和数量


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
