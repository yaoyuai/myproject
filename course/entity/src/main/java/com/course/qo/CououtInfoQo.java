package com.course.qo;

import lombok.Data;

@Data
public class CououtInfoQo extends PageQo {
    private String cououtId;
    private String studentId;
    private String courseId;
    private String stateId;
    private String cououtCtime;
    private String cououtMtime;
}
