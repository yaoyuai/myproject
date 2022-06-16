package com.course.vo;

import com.course.pojo.MaterialInfo;
import lombok.Data;

@Data
public class MaterialInfoVo extends MaterialInfo {
    private String courseName;
    private String teacherName;
    private String teacherNick;
}
