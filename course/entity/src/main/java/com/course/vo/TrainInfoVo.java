package com.course.vo;

import com.course.pojo.TrainInfo;
import lombok.Data;

@Data
public class TrainInfoVo extends TrainInfo {
    private String stateName;
    private String courseName;
    private String teacherName;
}
