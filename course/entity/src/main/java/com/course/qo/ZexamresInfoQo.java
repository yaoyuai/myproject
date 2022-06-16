package com.course.qo;

import lombok.Data;

@Data
public class ZexamresInfoQo extends PageQo{
    private String zexamresId;
    private String examId;
    private String studentId;
    private String zexamresCtime;
    private String zexamresMtime;
    private String zexamresScore;

}
