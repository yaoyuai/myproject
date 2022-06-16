package com.course.qo;


import lombok.Data;

@Data
public class MaterialInfoQo extends PageQo{
    private String materialId;
    private String materialUrl;
    private String courseId;
    private String materialType;
    private String teacherId;
    private String materialCtime;
    private String materialName;
}
