package com.course.pojo;


import lombok.Data;

@Data
public class ZexamresInfo {
    private int zexamresId;
    private int examId;
    private int studentId;
    private String zexamresCtime;
    private String zexamresMtime;
    private double zexamresScore;

}
