package com.course.qo;


import lombok.Data;

@Data
public class KexamresInfoQo extends PageQo {

    private String kexamresId;
    private String examId;
    private String studentId;
    private String stateId;
    private String kexamresCtime;
    private String kexamresMtime;
    private String kexamresScore;
    private String zexamContent;
    private String examSum;

}
