package com.course.pojo;


import lombok.Data;

@Data
public class MaterialInfo {
    private int materialId;
    private String materialUrl;
    private int courseId;
    private String materialType;
    private int teacherId;
    private String materialCtime;

    private String materialName;

}
