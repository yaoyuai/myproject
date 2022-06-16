package com.course.vo;

import com.course.pojo.ZcontentInfo;
import lombok.Data;

@Data
public class ZcontentInfoVo extends ZcontentInfo {

    private String studentName;
    private String stateName;
    private String examName;
    private String examCtime;
    private String exerContent;
    private String exerValue;

}
