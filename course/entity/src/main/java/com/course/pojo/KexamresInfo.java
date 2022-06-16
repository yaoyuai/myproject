package com.course.pojo;


import lombok.Data;

@Data
public class KexamresInfo {
    private int kexamresId;
    private int examId;
    private int studentId;
    private int stateId;
    private String kexamresCtime;
    private String kexamresMtime;
    private double kexamresScore;
}
