package com.course.vo;

import com.course.pojo.ExerInfo;
import lombok.Data;

import java.util.List;

@Data
public class ExerInfoVo extends ExerInfo {

    private String examName;
    private String trainName;
    private List<ChooseInfoVo> chooseInfoVoList;

}
